package com.kururu.skillup.algorithm.problems.sorting;

/**
 * <h2>Bubble Sorting</h2>
 * <ol>
 *     <li>Sort image : <a href = "https://eleni.blog/2019/06/09/sorting-in-go-using-bubble-sort/">LINK</a></li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class BubbleSorting extends AbstractSorting {

    public BubbleSorting(int[] targetArray, boolean reverseFlg) {
        super(targetArray, reverseFlg);
    }

    @Override
    public void process() {
        for (int i = 0; i < targetArray.length; i++) {
            for (int j = 0; j < targetArray.length - i - 1; j++) {
                if (reverseFlg) {
                    if (targetArray[j] < targetArray[j + 1]) {
                        int temp = targetArray[j + 1];
                        targetArray[j + 1] = targetArray[j];
                        targetArray[j] = temp;
                    }
                } else {
                    if (targetArray[j] > targetArray[j + 1]) {
                        int temp = targetArray[j + 1];
                        targetArray[j + 1] = targetArray[j];
                        targetArray[j] = temp;
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
