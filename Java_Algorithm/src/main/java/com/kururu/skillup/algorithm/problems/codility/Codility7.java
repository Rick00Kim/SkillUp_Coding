package com.kururu.skillup.algorithm.problems.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 *
 * <li>Test Result : https://app.codility.com/demo/results/trainingTF9YSN-37P/</li>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class Codility7 extends AbstractCodility {

    private int[] inputArray = new int[]{3, 4, 3, 2, 3, -1, 3, 3};

    private int result;

    @Override
    public void process() {

        Map<Integer, Integer> elementMap = new HashMap<>();
        int dominator = 0;
        int count = 0;

        for (int element : inputArray) {
            if (elementMap.containsKey(element)) {
                int tempCount = elementMap.get(element);
                elementMap.put(element, ++tempCount);
                if (tempCount > count) {
                    count = tempCount;
                    dominator = element;
                }
            } else {
                elementMap.put(element, 1);
            }
        }

        if (inputArray.length == 1) {
            result = 0;
            return;
        }
        if (count <= inputArray.length / 2) {
            result = -1;
            return;
        }
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == dominator) {
                result = i;
                return;
            }
        }

        result = -1;

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
        return String.valueOf(0);
    }
}
