package com.kururu.skillup.algorithm.problems.codility;

public class Codility13 extends AbstractCodility {

    private int[] inputArray = new int[]{1, 0, 2, 0, 0, 2};

    @Override
    public void process() {

        int binarian = 0;
        for (int element : inputArray) {
            binarian += Math.pow(2, element);
        }
        System.out.println(binarian);

        int result = 0;
        for (char chk : Integer.toBinaryString(binarian).toCharArray()) {
            if (chk == '1') {
                result++;
            }
        }
        System.out.println(result);

    }

    @Override
    protected String getInputData() {
        return null;
    }

    @Override
    protected String getOutputData() {
        return null;
    }

    @Override
    protected String getExpectedResult() {
        return null;
    }
}
