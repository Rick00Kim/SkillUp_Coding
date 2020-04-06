package com.kururu.skillup.main;

import com.kururu.skillup.algorithm.AlgorithmIF;
import com.kururu.skillup.algorithm.problems.codility.Codility12;
import lombok.extern.slf4j.Slf4j;

/**
 * Algorithm Tests Executer
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Executor {
    public static void main(String[] args) {
        // Polymorphism Definition
        AlgorithmIF algorithmProblem = new Codility12();
        // Call Input
        algorithmProblem.input();
        // Call Process
        algorithmProblem.process();
        // Call Output
        algorithmProblem.output();

    }
}
