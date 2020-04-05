package com.kururu.skillup.algorithm.problems;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Algorithm8 implements AlgorithmIF {

    private int x, y, d;

    @Override
    public void input() {
        x = 10;
        y = 85;
        d = 30;
    }

    @Override
    public void process() {
        if ((x > y) ||
                checkRange(new int[]{x, y, d}, 1000000000)) {
            return;
        }
        int result = 0;

        if ((y - x) % d > 0) {
            result = ((y - x) / d) + 1;
        } else {
            result = ((y - x) / d);
        }

        log.info(String.valueOf(result));
    }

    @Override
    public void output() {

    }

    private boolean checkRange(int[] targets, int to) {
        for (int target : targets) {
            return target < 1 || target > to;
        }
        return true;
    }
}
