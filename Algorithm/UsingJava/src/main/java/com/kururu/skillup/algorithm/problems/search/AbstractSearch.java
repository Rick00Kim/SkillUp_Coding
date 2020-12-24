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

    private static final String RESULT_MESSAGE = "Target : %s, Search Result : %s";

    protected int[] targetArray;
    protected int searchTarget;
    protected boolean result;

    private long startTime;

    @Override
    public void input() {
        log.info(getSearchName() + " is Started");
        startTime = System.currentTimeMillis();
    }

    public void input(int[] targetArray, int searchTarget) {
        this.targetArray = targetArray;
        this.searchTarget = searchTarget;
        input();
    }

    @Override
    public void output() {
        long secDiffTime = (System.currentTimeMillis() - startTime);
        log.info(getSearchName() + "'s Executing time : " + secDiffTime);
        log.info(getSearchName() + " is Finished");
        log.info(String.format(RESULT_MESSAGE, searchTarget, result));
    }

    protected abstract String getSearchName();
}
