package com.kururu.skillup.algorithm.problems;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem URL : https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 *
 * @Author Rick00Kim dreamx119@gmail.com
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

        if (!checkRange(inputArray.length, 1, 1000000)) {
            return;
        }

        Set<Integer> skipIndex = new HashSet<>();

        int result = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (!checkRange(inputArray[i], 1, 1000000000)) {
                return;
            }
            if (skipIndex.contains(i)) {
                continue;
            }
            for (int j = i + 1; j < inputArray.length; j++) {

                if (!checkRange(inputArray[i], 1, 1000000000)) {
                    return;
                }

                if (inputArray[i] == inputArray[j]) {
                    skipIndex.add(j);
                    break;
                }

            }
        }

        log.info(String.valueOf(result));
    }

    @Override
    public void output() {

    }

    private boolean checkRange(int target, int from, int to) {
        return target >= from && target <= to;
    }
}
