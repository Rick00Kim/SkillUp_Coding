package com.kururu.skillup.algorithm.problems.codility;

import lombok.extern.slf4j.Slf4j;

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Codility1 extends AbstractCodility {

    private int inputInteger = 1041;

    private int result = 0;

    @Override
    public void process() {

        final String binary = Integer.toBinaryString(inputInteger);

        final char[] charArray = binary.toCharArray();

        int gap = 0;

        for (char element : charArray) {
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
