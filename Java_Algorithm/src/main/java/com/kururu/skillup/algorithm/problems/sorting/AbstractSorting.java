package com.kururu.skillup.algorithm.problems.sorting;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

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

    protected int[] targetArray;

    private long startTime;

    public AbstractSorting(int[] targetArray) {
        this.targetArray = targetArray;
    }

    @Override
    public void input() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void output() {
        long secDiffTime = (System.currentTimeMillis() - startTime);
        log.info(getSortName() + "'s Executing time : " + secDiffTime);
    }

    protected abstract String getSortName();

}
