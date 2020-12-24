package com.kururu.skillup.algorithm.problems.sorting;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;

/**
 * <h2>Abstract Class Sorting Algorithm</h2>
 * <ol>
 *     <li>O(n²) : Bubble Sort, Selection Sort, Insertion Sort, Shell Sort, Quick Sort</li>
 *     <li>O(n log n) : Heap Sort, Merge Sort</li>
 *     <li>O(kn) : Radix Sort</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public abstract class AbstractSorting implements AlgorithmIF {

    private static final String EXECUTE_RESULT_MESSAGE = "%s`s Result : %s";
    private static final String VALIDATE_MESSAGE = "Sort is not correct(Before : %d, After : %d, ReverseFlg : %s)";

    protected int[] targetArray;

    protected boolean reverseFlg;

    private long startTime;

    private long secDiffTime;

    /**
     * Constructor
     *
     * @param targetArray
     * @param reverseFlg
     */
    public AbstractSorting(int[] targetArray, boolean reverseFlg) {
        this.targetArray = targetArray;
        this.reverseFlg = reverseFlg;
    }

    @Override
    public void input() {
        log.info(getSortName() + " is Started, ReverseFlg : " + reverseFlg);
        startTime = System.currentTimeMillis();
    }

    @Override
    public void output() {
        secDiffTime = (System.currentTimeMillis() - startTime);
        log.info("Executing time : " + secDiffTime);
        log.info(getSortName() + " is Finished");

        try {
            postSortedArrayCheck();
        } catch (final IllegalArgumentException e) {
            log.error(String.format(EXECUTE_RESULT_MESSAGE, getSortName(), RESULT.FAILURE), e);
            return;
        }

        log.info(String.format(EXECUTE_RESULT_MESSAGE, getSortName(), RESULT.SUCCESS));

    }

    /**
     * Check Sorted(It Have to execute after executing process)
     */
    private void postSortedArrayCheck() {
        for (int i = 0; i < targetArray.length - 1; i++) {
            if (reverseFlg) {
                Validate.isTrue(targetArray[i] >= targetArray[i + 1], String.format(VALIDATE_MESSAGE, targetArray[i], targetArray[i + 1], true));
            } else {
                Validate.isTrue(targetArray[i] <= targetArray[i + 1], String.format(VALIDATE_MESSAGE, targetArray[i], targetArray[i + 1], false));
            }
        }

    }

    public long getSecDiffTime() {
        return secDiffTime;
    }

    protected abstract String getSortName();

}
