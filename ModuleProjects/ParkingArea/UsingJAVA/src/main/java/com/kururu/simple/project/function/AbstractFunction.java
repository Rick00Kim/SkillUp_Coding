package com.kururu.simple.project.function;

import java.util.Map;

public abstract class AbstractFunction implements FunctionIF {

    /* Input Map */
    protected static Map<Integer, Object> inputMap;

    @Override
    public void execute() {

        /* Call InputAndValidate Method */
        inputAndValidate();

        /* Call Main Method */
        process();

        /* Call Finally Method */
        onFinally();

    }

    protected void onFinally() {
        inputMap.clear();
    }

    protected abstract void inputAndValidate();

    protected abstract void process();

}
