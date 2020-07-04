package com.kururu.simple.project.function;

import static com.kururu.simple.project.constant.ParkingAreaConstants.WARN_MESSAGE_INPUT_ERROR;

import com.kururu.simple.project.dto.ExitingCarDto;
import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.entity.EntryBookIdentity;
import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.utility.common.DateComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * <h2>Parking Area [Exit car from parking area]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class ExitingCar extends AbstractFunction {

    private static final String TARGET_EXITING_CAR_DTO = "targetExitingCarDto";

    private static final String TARGET_ENTRY_BOOK = "targetEntryBook";

    private static final String NOT_EXIST_ENTRY_BOOK = "Not using Parking Area (Vehicle Number : %s, Client Number : %s)";

    @Autowired
    private EntryBookRepository entryBookRepository;

    @Autowired
    private DateComponent dateComponent;

    @Override
    protected RESULT_STATUS input() {

        final ExitingCarDto exitingCarDto = ExitingCarDto.builder().build();
        try {
            exitingCarDto.setVehicleNumber(userInputComponent.getUserInput("Vehicle number : "));
            exitingCarDto.setClientNumber(userInputComponent.getUserInput("Client number : "));
            functionMap.put(TARGET_EXITING_CAR_DTO, exitingCarDto);
        } catch (Exception e) {
            log.warn(String.format(WARN_MESSAGE_INPUT_ERROR, "INPUT"), e);
            return RESULT_STATUS.FAILURE;
        }
        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS validate() {
        final ExitingCarDto targetExitingCarDto = (ExitingCarDto) functionMap.get(TARGET_EXITING_CAR_DTO);
        final EntryBook targetEntryBook = entryBookRepository
                .findById(EntryBookIdentity.builder().vehicleNumber(targetExitingCarDto.getVehicleNumber())
                        .clientNumber(targetExitingCarDto.getClientNumber())
                        .lotNumber(currentLotInformation.getLotNumber()).build())
                .orElse(null);
        if (ObjectUtils.isEmpty(targetEntryBook)) {
            log.warn(String.format(NOT_EXIST_ENTRY_BOOK, targetExitingCarDto.getVehicleNumber(),
                    targetExitingCarDto.getClientNumber()));
            return RESULT_STATUS.FAILURE;
        }
        functionMap.put(TARGET_ENTRY_BOOK, targetEntryBook);
        return RESULT_STATUS.SUCCESS;
    }

    @Override
    public RESULT_STATUS process() {
        final EntryBook targetEntryBook = (EntryBook) functionMap.get(TARGET_ENTRY_BOOK);
        modifyEntryBook(targetEntryBook);
        entryBookRepository.save(targetEntryBook);
        return RESULT_STATUS.SUCCESS;
    }

    private void modifyEntryBook(EntryBook entryBook) {
        entryBook.setDepartureTime(dateComponent.getCurrentTimestamp());
        long hours = (entryBook.getDepartureTime().getTime() - entryBook.getArrivalTime().getTime()) / 3600000;
        entryBook.setHoursOfUse((int) hours);
        entryBook.setCostOfUse((entryBook.getHoursOfUse() * 1000) == 0 ?
                1000 : entryBook.getHoursOfUse() * 1000);
    }
}
