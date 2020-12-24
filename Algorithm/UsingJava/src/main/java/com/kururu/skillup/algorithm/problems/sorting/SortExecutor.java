package com.kururu.skillup.algorithm.problems.sorting;

import org.apache.commons.lang3.RandomUtils;

/**
 * Sorting Executor
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class SortExecutor {

    private static final Integer MAX_INDEX = 50000;
    private static int[] targetArray;

    static {
        targetArray = new int[MAX_INDEX];
        for (int i = 0; i < MAX_INDEX; i++) {
            targetArray[i] = RandomUtils.nextInt(0, Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {

        // Define
        AbstractSorting sorting = new QuickSorting(targetArray, false);
        // Input
        sorting.input();
        // Process
        sorting.process();
        // Output
        sorting.output();
    }
}
