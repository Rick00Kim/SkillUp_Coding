package com.kururu.skillup.algorithm;

/**
 * Algorithm Executable Interface
 *
 * @Author Rick00Kim dreamx119@gmail.com
 */
public interface AlgorithmIF {

    enum RESULT {
        SUCCESS, FAILURE
    }

    /**
     * Prepare Test data
     */
    void input();

    /**
     * Algorithm processing
     */
    void process();

    /**
     * Check Result
     * {@link RESULT}
     */
    void output();

}
