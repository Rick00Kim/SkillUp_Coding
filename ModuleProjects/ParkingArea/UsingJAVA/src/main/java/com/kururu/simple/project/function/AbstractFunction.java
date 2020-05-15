package com.kururu.simple.project.function;

import com.google.common.collect.Maps;

import java.util.Map;

public abstract class AbstractFunction implements FunctionIF {

    /* Key for input method */
    protected static final String KEY_INPUT = "keyInput";

    /* Map in Function */
    protected static Map<String, Object> functionMap = Maps.newHashMap();

    protected enum RESULT_STATUS {
        SUCCESS, FAILURE
    }

    @Override
    public void execute() {
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
