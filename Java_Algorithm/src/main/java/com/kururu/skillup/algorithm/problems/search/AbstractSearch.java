package com.kururu.skillup.algorithm.problems.search;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

/**
 * <h2>Abstract Class Search Algorithm</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public abstract class AbstractSearch implements AlgorithmIF {

    protected int[] targetArray;

    private long startTime;

    public AbstractSearch(int[] targetArray) {
        this.targetArray = targetArray;
    }

    @Override
    public void input() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void output() {
        long secDiffTime = (System.currentTimeMillis() - startTime);
        log.info(getSearchName() + "'s Executing time : " + secDiffTime);
    }

    protected abstract String getSearchName();
}
