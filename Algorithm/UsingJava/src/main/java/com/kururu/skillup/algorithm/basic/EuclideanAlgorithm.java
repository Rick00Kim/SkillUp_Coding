package com.kururu.skillup.algorithm.basic;

import lombok.extern.slf4j.Slf4j;
import com.kururu.skillup.algorithm.AlgorithmIF;

/**
 * <h2>Euclidean Algorithm</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class EuclideanAlgorithm implements AlgorithmIF {

    private static final String RESULT_MESSAGE_FORMAT = "Method Name : %s, Result : %d";

    private int[] inputArray;

    private int[] resultArray = new int[2];

    @Override
    public void input() {
        inputArray = new int[]{136, 85};
    }

    @Override
    public void process() {
        resultArray[0] = gcdRecursive(inputArray[0], inputArray[1]);
        resultArray[1] = gcdNonRecursive(inputArray[0], inputArray[1]);
    }

    @Override
    public void output() {
        log.info(String.format(RESULT_MESSAGE_FORMAT, "gcdRecursive", resultArray[0]));
        log.info(String.format(RESULT_MESSAGE_FORMAT, "gcdNonRecursive", resultArray[1]));
    }

    private int gcdRecursive(int target1, int target2) {
        if (target2 == 0) return target1;
        else return gcdRecursive(target2, target1 % target2);
    }

    private int gcdNonRecursive(int target1, int target2) {
        while (target2 != 0) {
            int temp = target2;
            target2 = target1 % target2;
            target1 = temp;
        }
        return target1;
    }
}
