package com.kururu.simple.project.function;

import com.google.common.collect.Maps;
import com.kururu.simple.project.entity.LotInformation;
import com.kururu.simple.project.utility.components.UserInputComponent;
import com.kururu.simple.project.utility.factory.CurrentLotInformationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * <h2>Parking Area [Abstract for Function]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public abstract class AbstractFunction implements FunctionIF {

    /* Map in Function */
    protected static Map<String, Object> functionMap = Maps.newHashMap();

    @Autowired
    private CurrentLotInformationFactory currentLotInformationFactory;

    @Autowired
    protected UserInputComponent userInputComponent;

    protected LotInformation currentLotInformation;

    /* RESULT_STATUS */
    protected enum RESULT_STATUS {
        SUCCESS, FAILURE
    }

    @Override
    public void execute() {

        /* Check Current Lot information */
        this.currentLotInformation = currentLotInformationFactory.getCurrentLotInformation();
        if (ObjectUtils.isEmpty(currentLotInformation)) {
            return;
        }
        /* Call input Method */
        if (RESULT_STATUS.SUCCESS != input()) {
            return;
        }
        /* Call input Method */
        if (RESULT_STATUS.SUCCESS != validate()) {
            return;
        }
        /* Call Main Method */
        if (RESULT_STATUS.SUCCESS != process()) {
            return;
        }
        /* Call Finally Method */
        onFinally();
    }

    /**
     * Finally Method
     * Clear Map basically
     */
    protected void onFinally() {
        functionMap.clear();
    }

    /**
     * Get Input (when was need)
     */
    protected abstract RESULT_STATUS input();

    /**
     * Validate
     */
    protected abstract RESULT_STATUS validate();

    /**
     * Main process of function
     */
    protected abstract RESULT_STATUS process();

}
