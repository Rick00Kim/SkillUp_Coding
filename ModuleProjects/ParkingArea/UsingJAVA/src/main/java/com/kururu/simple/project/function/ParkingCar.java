package com.kururu.simple.project.function;

import static com.kururu.simple.project.constant.ParkingAreaConstants.WARN_MESSAGE_INPUT_ERROR;

import com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;
import com.kururu.simple.project.constant.ParkingAreaEnums.CAR_SIZE;
import com.kururu.simple.project.dto.ParkingCarDto;
import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.entity.EntryBookIdentity;
import com.kururu.simple.project.repository.condition.CountExistAreaCondition;
import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.utility.common.DateComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <h2>Parking Area [Park new car to free area]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class ParkingCar extends AbstractFunction {

    private static final String PARKING_CAR_DTO = "parkingCarDto";

    @Autowired
    private EntryBookRepository entryBookRepository;

    @Autowired
    private DateComponent dateComponent;

    @Override
    protected RESULT_STATUS input() {

        final ParkingCarDto parkingCarDto = ParkingCarDto.builder().build();
        try {
            parkingCarDto.setVehicleNumber(
                    userInputComponent.getUserInput("Vehicle number : "));
            parkingCarDto.setInputCarSize(
                    Objects.requireNonNull(
                            CAR_SIZE.getValue(
                                    userInputComponent.getUserInput("Car size : ")),
                            String.format(WARN_MESSAGE_INPUT_ERROR, "CAR_SIZE")));
        } catch (Exception e) {
            log.warn(String.format(WARN_MESSAGE_INPUT_ERROR, "INPUT"), e);
            return RESULT_STATUS.FAILURE;
        }

        functionMap.put(PARKING_CAR_DTO, parkingCarDto);

        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS validate() {

        final ParkingCarDto parkingCarDto = (ParkingCarDto) functionMap.get(PARKING_CAR_DTO);
        final CountExistAreaCondition countExistAreaCondition = CountExistAreaCondition.builder()
                .lotNumber(currentLotInformation.getLotNumber())
                .carSize(parkingCarDto.getInputCarSize())
                .pairTermADay(dateComponent.getDateTermADay())
                .build();

        final int count = entryBookRepository.countExistEmptyArea(countExistAreaCondition);
        switch (parkingCarDto.getInputCarSize()) {
            case SMALL:
                if (count >= currentLotInformation.getAcceptableSmall())
                    return RESULT_STATUS.FAILURE;
            case MEDIUM:
                if (count >= currentLotInformation.getAcceptableMedium())
                    return RESULT_STATUS.FAILURE;
            case HEAVY:
                if (count >= currentLotInformation.getAcceptableHeavy())
                    return RESULT_STATUS.FAILURE;
        }

        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS process() {

        final ParkingCarDto parkingCarDto = (ParkingCarDto) functionMap.get(PARKING_CAR_DTO);
        entryBookRepository.save(EntryBook.builder()
                .key(EntryBookIdentity.builder()
                        .vehicleNumber(parkingCarDto.getVehicleNumber())
                        .clientNumber("Non-Member")
                        .lotNumber(currentLotInformation.getLotNumber())
                        .build())
                .carSize(parkingCarDto.getInputCarSize())
                .arrivalTime(dateComponent.getCurrentTimestamp())
                .endBusinessFlg(END_BUSINESS_FLG.BUSINESS_NOT_ENDED)
                .build());

        return RESULT_STATUS.SUCCESS;
    }

}
