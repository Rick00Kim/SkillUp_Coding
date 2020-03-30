package com.kururu.skillup.main;

import com.kururu.skillup.algorithm.AlgorithmIF;
import com.kururu.skillup.algorithm.problems.Algorithm4;
import lombok.extern.slf4j.Slf4j;

/**
 * Algorithm Tests Executer
 *
 * @Author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Executer {
    public static void main(String[] args) {
        // Polymorphism Definition
        AlgorithmIF algorithmProblem = new Algorithm4();
        // Call Input
        algorithmProblem.input();
        // Call Process
        algorithmProblem.process();
        // Call Output
        algorithmProblem.output();

    }
}
