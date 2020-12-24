package com.kururu.skillup.algorithm.problems.search;

import java.util.Arrays;

/**
 * <h2>Binary Search</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class BinarySearch extends AbstractSearch {

    @Override
    public void input(int[] targetArray, int searchTarget) {
        Arrays.sort(targetArray);
        super.input(targetArray, searchTarget);
    }

    @Override
    public void process() {

        int leftIndex = 0;
        int rightIndex = targetArray.length - 1;

        while (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (searchTarget == targetArray[mid]) {
                result = true;
                return;
            }
            if (searchTarget < targetArray[mid]) {
                rightIndex = mid - 1;
            } else {
                leftIndex = mid + 1;
            }
        }
    }

    @Override
    protected String getSearchName() {
        return getClass().getSimpleName();
    }
}
