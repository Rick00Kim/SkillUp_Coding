package com.kururu.skillup.algorithm.problems;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem URL : https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Algorithm7 implements AlgorithmIF {

    private int[] inputArray = null;

    @Override
    public void input() {
        inputArray = new int[]{9, 3, 9, 3, 9, 7, 9};
    }

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

        log.info(String.valueOf((int) skipElements.iterator().next()));
    }

    @Override
    public void output() {

    }

    private boolean checkRange(int target, int from, int to) {
        return target < from || target > to;
    }
}
