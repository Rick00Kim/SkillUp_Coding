package com.kururu.skillup.algorithm.problems.sorting;

/**
 * <h2>Selection Sorting</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class SelectionSorting extends AbstractSorting {

    public SelectionSorting(int[] targetArray) {
        super(targetArray);
    }

    @Override
    public void process() {

        for (int i = 0; i < targetArray.length - 1; i++) {
            for (int j = i + 1; j < targetArray.length; j++) {
                if (targetArray[i] > targetArray[j]) {
                    int temp = targetArray[j];
                    targetArray[j] = targetArray[i];
                    targetArray[i] = temp;
                }
            }
        }
    }

    @Override
    protected String getSortName() {
        return getClass().getSimpleName();
    }
}
