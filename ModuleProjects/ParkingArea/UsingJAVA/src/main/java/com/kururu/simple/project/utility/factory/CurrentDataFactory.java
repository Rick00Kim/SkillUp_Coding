package com.kururu.simple.project.utility.factory;

import static com.kururu.simple.project.constant.ParkingAreaConstants.WARN_MESSAGE_NOT_NULL;
import static com.kururu.simple.project.utility.common.CommonElements.USER_INPUT_READER;

import com.kururu.simple.project.entity.LotInformation;
import com.kururu.simple.project.repository.LotInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

/**
 * <h2>Parking Area [Current Data Factory]</h2>
 * <ol>
 *     <li>Lot Information</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class CurrentDataFactory {

    @Autowired
    private LotInformationRepository lotInformationRepository;

    private LotInformation currentLotInformation = null;

    /**
     * Check Exist Current Lot information
     *
     * @return Exist : true, Not Exist : false
     */
    public boolean isExistCurrentLotInformation() {
        return !ObjectUtils.isEmpty(currentLotInformation);
    }

    /**
     * Get Current Lot Information
     *
     * @return Managed Lot Information
     */
    public LotInformation getCurrentLotInformation() {
        if (ObjectUtils.isEmpty(currentLotInformation))
            try {
                log.info("\nWhat is your Lot Name : ");
                final LotInformation inputLotInformation = lotInformationRepository.findByLotName(USER_INPUT_READER.readLine());
                if (ObjectUtils.isEmpty(inputLotInformation)) {
                    log.warn(String.format(WARN_MESSAGE_NOT_NULL, "LOT_INFORMATION"));
                }
                currentLotInformation = inputLotInformation;
            } catch (IOException e) {
                log.warn("Failed when getting Lot Information", e);
            }
        if (isExistCurrentLotInformation()) {
            log.info(String.format("CURRENT Lot Information -> [%s]", currentLotInformation.getLotName()));
        } else {
            log.info("Not set Lot Information");
        }

        return currentLotInformation;
    }

}
