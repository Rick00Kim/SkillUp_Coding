package com.kururu.skillup.algorithm.problems.codility;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 *
 * <li>Test Result : https://app.codility.com/demo/results/trainingWD8ESU-H3X/</li>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility10 extends AbstractCodility {

    private int inputInteger = 24;

    private int result = 0;

    @Override
    public void process() {

        int sqrt = (int) Math.sqrt(inputInteger);

        for (int i = 1; i <= inputInteger; i++) {
            if (inputInteger % i == 0) {
                result++;
            }
        }

        result = result * 2;

        if (sqrt * sqrt == inputInteger) {
            result = result - 1;
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
        return "8";
    }
}
