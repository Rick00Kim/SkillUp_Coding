package com.kururu.simple.project.utility.factory;

import static com.kururu.simple.project.constant.ParkingAreaConstants.WARN_MESSAGE_NOT_NULL;

import com.kururu.simple.project.entity.LotInformation;
import com.kururu.simple.project.repository.LotInformationRepository;
import com.kururu.simple.project.utility.components.UserInputComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * <h2>Parking Area [Current Lot Information Factory]</h2>
 * <ol>
 *     <li>Lot Information</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class CurrentLotInformationFactory {

    @Autowired
    private LotInformationRepository lotInformationRepository;

    @Autowired
    private UserInputComponent userInputComponent;

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
        if (isExistCurrentLotInformation()) {
            log.info(String.format("CURRENT Lot Information -> [%s]", currentLotInformation.getLotName()));
        } else {
            log.info("Not set Lot Information");
            final LotInformation inputLotInformation = lotInformationRepository.findByLotName(
                    userInputComponent.getUserInput("What is your Lot Name : "));
            if (ObjectUtils.isEmpty(inputLotInformation)) {
                log.warn(String.format(WARN_MESSAGE_NOT_NULL, "LOT_INFORMATION"));
            }
            currentLotInformation = inputLotInformation;
        }

        return currentLotInformation;
    }

}
