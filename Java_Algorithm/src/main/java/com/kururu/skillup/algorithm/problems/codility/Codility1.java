package com.kururu.skillup.algorithm.problems.codility;

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility1 extends AbstractCodility {

    private int inputInteger = 1041;

    private int result = 0;

    @Override
    public void process() {

        final String binary = Integer.toBinaryString(inputInteger);

        int gap = 0;

        for (char element : binary.toCharArray()) {
            if (element == '0') {
                ++gap;
            } else {
                if (gap > result) {
                    result = gap;
                }
                gap = 0;
            }
        }
    }

    @Override
    protected String getInputData() {
        return String.valueOf(inputInteger);
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
