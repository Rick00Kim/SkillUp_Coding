package com.kururu.simple.project.function;

import static com.kururu.simple.project.constant.ParkingAreaConstants.WARN_MESSAGE_NOT_NULL;
import static com.kururu.simple.project.constant.ParkingAreaConstants.WARN_MESSAGE_INPUT_ERROR;
import static com.kururu.simple.project.utility.common.CommonElements.USER_INPUT_READER;

import com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;
import com.kururu.simple.project.constant.ParkingAreaEnums.CAR_SIZE;
import com.kururu.simple.project.dto.ParkingCarDto;
import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.entity.EntryBookIdentity;
import com.kururu.simple.project.repository.condition.CheckExistAreaCondition;
import com.kururu.simple.project.entity.LotInformation;
import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.repository.LotInformationRepository;
import com.kururu.simple.project.utility.common.DateComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
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
    private static final String TARGET_LOT_INFORMATION = "lotInformation";

    @Autowired
    private LotInformationRepository lotInformationRepository;

    @Autowired
    private EntryBookRepository entryBookRepository;

    @Autowired
    private DateComponent dateComponent;

    @Override
    protected RESULT_STATUS input() {
        final ParkingCarDto parkingCarDto = ParkingCarDto.builder().build();
        try {
            log.info("\nLot name : ");
            parkingCarDto.setInputLotName(USER_INPUT_READER.readLine());
            log.info("\nVehicle number : ");
            parkingCarDto.setVehicleNumber(USER_INPUT_READER.readLine());
            log.info("\nCar size : ");
            parkingCarDto.setInputCarSize(
                    Objects.requireNonNull(CAR_SIZE.getValue(USER_INPUT_READER.readLine()),
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
        final LotInformation lotInformation = lotInformationRepository.findByLotName(parkingCarDto.getInputLotName());
        if (ObjectUtils.isEmpty(lotInformation)) {
            log.warn(String.format(WARN_MESSAGE_NOT_NULL, "LOT_INFORMATION"));
            return RESULT_STATUS.FAILURE;
        }
        final CheckExistAreaCondition checkExistAreaCondition = CheckExistAreaCondition.builder().build();
        checkExistAreaCondition.setLotNumber(lotInformation.getLotNumber());
        checkExistAreaCondition.setCarSize(parkingCarDto.getInputCarSize());
        final Pair<Timestamp, Timestamp> pairTermADay = dateComponent.getDateTermADay();
        checkExistAreaCondition.setBefore(pairTermADay.getLeft());
        checkExistAreaCondition.setAfter(pairTermADay.getRight());
        int count = entryBookRepository.countExistEmptyArea(checkExistAreaCondition);
        switch (parkingCarDto.getInputCarSize()) {
            case SMALL:
                if (count >= lotInformation.getAcceptableSmall())
                    return RESULT_STATUS.FAILURE;
            case MEDIUM:
                if (count >= lotInformation.getAcceptableMedium())
                    return RESULT_STATUS.FAILURE;
            case HEAVY:
                if (count >= lotInformation.getAcceptableHeavy())
                    return RESULT_STATUS.FAILURE;
        }

        functionMap.put(TARGET_LOT_INFORMATION, lotInformation);
        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS process() {
        final ParkingCarDto parkingCarDto = (ParkingCarDto) functionMap.get(PARKING_CAR_DTO);
        final LotInformation lotInformation = (LotInformation) functionMap.get(TARGET_LOT_INFORMATION);

        final EntryBook entryBook = EntryBook.builder()
                .key(EntryBookIdentity.builder()
                        .vehicleNumber(parkingCarDto.getVehicleNumber())
                        .clientNumber("Non-Member")
                        .build())
                .lotNumber(lotInformation.getLotNumber())
                .carSize(parkingCarDto.getInputCarSize())
                .arrivalTime(dateComponent.getCurrentTimestamp())
                .endBusinessFlg(END_BUSINESS_FLG.BUSINESS_NOT_ENDED)
                .build();
        entryBookRepository.save(entryBook);
        return RESULT_STATUS.SUCCESS;
    }

}
