package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/
 *
 * <li>Test Result : https://app.codility.com/demo/results/trainingJHFQ4Z-F3H/</li>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility9 extends AbstractCodility {

    private int[] inputArray = new int[]{3, 2, -6, 4, 0};

    private int result = Integer.MIN_VALUE;

    @Override
    public void process() {
        if (inputArray == null) {
            result = 0;
            return;
        }

        if (inputArray.length == 1) {
            result = inputArray[0];
            return;
        }

        int accumulationNum = 0;

        for (int n : inputArray) {
            accumulationNum = Math.max(n, n + accumulationNum);
            result = Math.max(accumulationNum, result);
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
        return "5";
    }

}
