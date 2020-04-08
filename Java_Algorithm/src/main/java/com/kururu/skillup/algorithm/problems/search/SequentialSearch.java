package com.kururu.skillup.algorithm.problems.search;

/**
 * <h2>Sequential Search</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class SequentialSearch extends AbstractSearch {

    @Override
    public void process() {
        for (int element : targetArray) {
            if (element == searchTarget) {
                result = true;
                return;
            }
        }
    }

    @Override
    protected String getSearchName() {
        return getClass().getSimpleName();
    }
}
