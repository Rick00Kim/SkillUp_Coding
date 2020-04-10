package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility8 extends AbstractCodility {

    private int[] inputArray = new int[]{2, 1, 1, 2, 3, 1};

    private int result = 0;

    @Override
    public void process() {

        final Set<Integer> integerSet = new HashSet<>();

        for (int element : inputArray) {
            integerSet.add(element);
        }

        result = integerSet.size();
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
