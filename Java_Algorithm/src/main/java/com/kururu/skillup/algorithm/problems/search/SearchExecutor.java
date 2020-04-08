package com.kururu.skillup.algorithm.problems.search;

import org.apache.commons.lang3.RandomUtils;

public class SearchExecutor {

    private static final Integer MAX_INDEX = 300000;
    private static int[] targetArray;

    static {
        targetArray = new int[MAX_INDEX];
        for (int i = 0; i < MAX_INDEX; i++) {
            targetArray[i] = RandomUtils.nextInt(0, Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {
        AbstractSearch search = new BinarySearch();
        search.input(targetArray, targetArray[RandomUtils.nextInt(0, MAX_INDEX)]);
        search.process();
        search.output();
    }
}
