package com.kururu.skillup.algorithm.basic;

import com.kururu.skillup.algorithm.AlgorithmIF;

/**
 * <h2>Basic Algorithm Executor</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class BasicAlgorithmExecutor {

    public static void main(String[] args) {

        // Polymorphism Definition
        AlgorithmIF algorithm = new EuclideanAlgorithm();
        // Call Input
        algorithm.input();
        // Call Process
        algorithm.process();
        // Call Output
        algorithm.output();
    }
}
