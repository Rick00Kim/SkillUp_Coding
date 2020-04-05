package com.kururu.skillup.algorithm.problems;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Algorithm9 implements AlgorithmIF {

    private int[] inputArray;

    @Override
    public void input() {
        inputArray = new int[]{2, 3, 1, 5};
    }

    @Override
    public void process() {

        Arrays.sort(inputArray);

        Integer result = null;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != i + 1) {
                result = i + 1;
                break;
            }
        }
        if (result == null) {
            result = inputArray.length + 1;
        }

        log.info(String.valueOf(result));
    }

    @Override
    public void output() {

    }
}
