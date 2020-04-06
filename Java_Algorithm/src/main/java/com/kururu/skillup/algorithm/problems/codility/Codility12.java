package com.kururu.skillup.algorithm.problems.codility;

/**
 * https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/
 *
 * <li>Test Result : </li>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility12 extends AbstractCodility {

    private int inputN = 10;
    private int inputM = 4;

    private int result = 0;

    @Override
    public void process() {

    }

    @Override
    protected String getInputData() {
        return inputN + ", " + inputM;
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
