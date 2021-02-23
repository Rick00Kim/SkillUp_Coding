package com.kururu.skillup.algorithm.problems.codility;

import lombok.extern.slf4j.Slf4j;

/**
 * Algorithm Tests Executer
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class CodilityExecutor {
    public static void main(String[] args) {
        // Polymorphism Definition
        AbstractCodility codility = new CodilityTestForLine();
        // Call Input
        codility.input();
        // Call Process
        codility.process();
        // Call Output
        codility.output();

    }
}
