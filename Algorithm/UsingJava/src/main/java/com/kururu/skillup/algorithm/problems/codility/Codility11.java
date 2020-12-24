package com.kururu.skillup.algorithm.problems.codility;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 *
 * <li>Test Result : https://app.codility.com/demo/results/trainingB5RC7Y-QR4/</li>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility11 extends AbstractCodility {

    private int inputInteger = 30;

    private int result = Integer.MAX_VALUE;

    @Override
    public void process() {
        int sqrt = (int) Math.sqrt(inputInteger);

        for (int i = 1; i <= sqrt; i++) {
            if (inputInteger % i == 0) {
                int perimeter = 2 * (i + (inputInteger / i));
                if (result > perimeter) {
                    result = perimeter;
                }
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
        return "22";
    }
}
