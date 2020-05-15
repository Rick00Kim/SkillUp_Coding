package com.kururu.simple.project.function;

import org.springframework.stereotype.Component;

/**
 * <h2>Parking Area [Exit car from parking area]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
public class ExitingCar extends AbstractFunction {

    @Override
    protected RESULT_STATUS input() {

        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS validate() {
        return null;
    }

    @Override
    public RESULT_STATUS process() {

        return RESULT_STATUS.SUCCESS;
    }

}
