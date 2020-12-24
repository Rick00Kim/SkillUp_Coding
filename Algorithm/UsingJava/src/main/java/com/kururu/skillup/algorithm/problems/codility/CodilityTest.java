package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;

public class CodilityTest extends AbstractCodility {

    private int[] inputArray = new int[]{1, 0, 2, 0, 0, 2};
    private int result = 0;

    @Override
    public void process() {

        int binarian = 0;
        for (int element : inputArray) {
            binarian += Math.pow(2, element);
        }

        for (char chk : Integer.toBinaryString(binarian).toCharArray()) {
            if (chk == '1') {
                result++;
            }
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
        return "3";
    }
}
