package com.kururu.simple.project.controller;

import static com.kururu.simple.project.constant.ParkingAreaConstants.ALL_FUNCTION_MAP;

import com.kururu.simple.project.constant.ParkingAreaEnums.MENU_SHOW_FLG;
import com.kururu.simple.project.function.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * <h2>Parking Area [Function controller]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class FunctionController {

    /* Function 1 */
    @Autowired
    private ParkingCar parkingCar;

    /* Function 2 */
    @Autowired
    private ExitingCar exitingCar;

    /* Function 3 */
    @Autowired
    private ViewUsageState viewUsageState;

    /* Function 4 */
    @Autowired
    private CreateIncomeInformation createIncomeInformation;

    /* Function 5 */
    @Autowired
    private EndOfBusiness endOfBusiness;

    /**
     * Forward to Executing Function by User Input
     *
     * @param userInput User input
     * @return Exit Flag
     */
    public boolean forwardFunction(
            final String userInput
    ) {
        boolean result = false;

        switch (selectFunction(userInput)) {
            case 1:
                parkingCar.execute();
                break;
            case 2:
                exitingCar.execute();
                break;
            case 3:
                viewUsageState.execute();
                break;
            case 4:
                createIncomeInformation.execute();
                break;
            case 5:
                endOfBusiness.execute();
                break;
            case 6:
                log.info("Exit Program....");
                result = true;
                break;
            case 11:
                log.info("Not supported yet...");
                break;
            default:
                log.warn("Incorrect input...");
                break;
        }
        return result;
    }

    /**
     * Choose function Character
     *
     * @param userInput Parameter from User input
     * @return Function identifier
     */
    private Integer selectFunction(
            final String userInput
    ) {
        if (ObjectUtils.isEmpty(userInput)) {
            return 0;
        }
        for (final Map.Entry<Integer, Triple<String, String, MENU_SHOW_FLG>> mapEntry : ALL_FUNCTION_MAP.entrySet()) {
            if (mapEntry.getValue().getLeft().equalsIgnoreCase(userInput)
                    || mapEntry.getValue().getMiddle().equalsIgnoreCase(userInput)) {
                return mapEntry.getKey();
            }
        }
        return 0;
    }

}
