package com.kururu.skillup.algorithm.problems;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Problem URL : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Algorithm6 implements AlgorithmIF {

    private int[] inputArray = null;
    private int rotation;

    @Override
    public void input() {
        inputArray = new int[]{3, 8, 9, 7, 6};
        rotation = 3;
    }

    @Override
    public void process() {

        if (checkRange(inputArray.length, 0, 100)
                || checkRange(rotation, 0, 100)) {
            return;
        }

        for (int i = 0; i < rotation; i++) {
            for (int j = inputArray.length - 1; j > 0; j--) {
                if (checkRange(inputArray[j], -1000, 1000)
                        || checkRange(inputArray[j - 1], -1000, 1000)) {
                    return;
                }
                int temp = inputArray[j - 1];
                inputArray[j - 1] = inputArray[j];
                inputArray[j] = temp;
            }
        }
    }

    @Override
    public void output() {
        log.info(Arrays.toString(inputArray));
    }

    private boolean checkRange(int target, int from, int to) {
        return target < from || target > to;
    }
}
