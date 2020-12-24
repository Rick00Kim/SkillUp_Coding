package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem URL : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility2 extends AbstractCodility {

    private final Map<Integer, Object> inputMap = Collections.unmodifiableMap(new HashMap<Integer, Object>() {
        {
            put(1, 3);
            put(2, new int[]{3, 8, 9, 7, 6});
        }
    });

    private int[] inputArray;

    @Override
    public void process() {

        inputArray = (int[]) inputMap.get(2);

        if (checkRange(inputArray.length, 0, 100)
                || checkRange((int) inputMap.get(1), 0, 100)) {
            return;
        }

        for (int i = 0; i < (int) inputMap.get(1); i++) {
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
    protected String getInputData() {
        return inputMap.toString();
    }

    @Override
    protected String getOutputData() {
        return Arrays.toString(inputArray);
    }

    @Override
    protected String getExpectedResult() {
        return Arrays.toString(new int[]{9, 7, 6, 3, 8});
    }

    private boolean checkRange(int target, int from, int to) {
        return target < from || target > to;
    }
}
