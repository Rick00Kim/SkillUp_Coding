package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem URL : https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility3 extends AbstractCodility {

    private int[] inputArray = new int[]{9, 3, 9, 3, 9, 7, 9};

    private int result;

    @Override
    public void process() {

        if (checkRange(inputArray.length, 1, 1000000)) {
            return;
        }

        Set<Integer> skipElements = new HashSet<>();

        for (int element : inputArray) {
            if (checkRange(element, 1, 1000000000)) {
                return;
            }
            if (!skipElements.contains(element)) {
                skipElements.add(element);
                continue;
            }
            skipElements.remove(element);
        }

        result = skipElements.iterator().next();

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
        return "7";
    }

    private boolean checkRange(int target, int from, int to) {
        return target < from || target > to;
    }
}
