package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility6 extends AbstractCodility {

    private final Map<String, Object> inputMap = Collections.unmodifiableMap(new HashMap<String, Object>() {
        {
            put("N", 5);
            put("Array", new int[]{3, 4, 4, 6, 1, 4, 4});
        }
    });

    private int[] targetArray = null;

    @Override
    public void process() {

        int inputN = (int) inputMap.get("N");
        int[] inputArray = (int[]) inputMap.get("Array");

        targetArray = new int[inputN];

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
    }

    @Override
    protected String getInputData() {
        return inputMap.toString();
    }

    @Override
    protected String getOutputData() {
        return Arrays.toString(targetArray);
    }

    @Override
    protected String getExpectedResult() {
        return Arrays.toString(new int[]{3, 2, 2, 4, 2});
    }
}
