package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility5 extends AbstractCodility {

    private int[] inputArray = new int[]{2, 3, 1, 5};

    private Integer result = null;

    @Override
    public void process() {
        Arrays.sort(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != i + 1) {
                result = i + 1;
                break;
            }
        }

        if (result == null) {
            result = inputArray.length + 1;
        }
    }

    @Override
    protected String getInputData() {
        return Arrays.toString(inputArray);
    }

    @Override
    protected String getOutputData() {
        return String.valueOf(result);
    }

    @Override
    protected String getExpectedResult() {
        return "4";
    }
}
