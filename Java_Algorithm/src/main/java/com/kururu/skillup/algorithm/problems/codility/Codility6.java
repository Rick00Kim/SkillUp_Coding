package com.kururu.skillup.algorithm.problems.codility;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Codility6 implements AlgorithmIF {

    private int inputN;

    private int[] inputArray;

    @Override
    public void input() {
        inputN = 5;
        inputArray = new int[]{3, 4, 4, 6, 1, 4, 4};
    }

    @Override
    public void process() {
        int[] targetArray = new int[inputN];

        int maxValue = 0;

        for (int index : inputArray) {
            if (index == inputN + 1) {
                for (int i = 0; i < inputN; i++) {
                    targetArray[i] = maxValue;
                }
            } else {
                targetArray[index - 1]++;
                for (int i = 0; i < inputN; i++) {
                    if (targetArray[i] > maxValue) {
                        maxValue = targetArray[i];
                    }
                }
            }
        }

        log.info(Arrays.toString(targetArray));

    }

    @Override
    public void output() {

    }
}
