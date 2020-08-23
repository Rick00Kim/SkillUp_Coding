package com.kururu.skillup.algorithm.problems.sorting;

/**
 * <h2>Insertion Sorting</h2>
 * <ol>
 *     <li>Sort image : <a href = "https://www.geeksforgeeks.org/insertion-sort/">LINK</a></li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class InsertionSorting extends AbstractSorting {

    public InsertionSorting(int[] targetArray, boolean reverseFlg) {
        super(targetArray, reverseFlg);
    }

    @Override
    public void process() {
        for (int i = 1; i < targetArray.length; i++) {
            int temp = targetArray[i];
            for (int j = i - 1; j >= 0; j--) {
                if (reverseFlg) {
                    if (targetArray[j] < temp) {
                        targetArray[j + 1] = targetArray[j];
                    } else {
                        break;
                    }
                } else {
                    if (targetArray[j] > temp) {
                        targetArray[j + 1] = targetArray[j];
                    } else {
                        break;
                    }
                }
            }
        }
    }

    @Override
    protected String getSortName() {
        return getClass().getSimpleName();
    }
}
