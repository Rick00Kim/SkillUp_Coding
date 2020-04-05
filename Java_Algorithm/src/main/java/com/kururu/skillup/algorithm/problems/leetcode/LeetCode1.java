package com.kururu.skillup.algorithm.problems.leetcode;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;


/**
 * Problem URL : https://leetcode.com/problems/alphabet-board-path/description/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class LeetCode1 implements AlgorithmIF {

    private static final String TARGET = "leet";
    private static final String DESTINATION = "DDR!UURRR!!DDD!";

    private String result = null;

    @Override
    public void input() {

    }

    @Override
    public void process() {

        int[] currentPosition = {0, 0};

        final StringBuilder sb = new StringBuilder();

        for (char subChar : TARGET.toCharArray()) {
            int[] nc = new int[]{(subChar - 'a') / 5, (subChar - 'a') % 5};

            while (nc[0] < currentPosition[0]) {
                sb.append('U');
                nc[0]++;
            }
            while (nc[1] < currentPosition[1]) {
                sb.append('L');
                nc[1]++;
            }
            while (nc[0] > currentPosition[0]) {
                sb.append('D');
                nc[0]--;
            }
            while (nc[1] > currentPosition[1]) {
                sb.append('R');
                nc[1]--;
            }

            currentPosition = new int[]{(subChar - 'a') / 5, (subChar - 'a') % 5};
            sb.append("!");
        }
        result = sb.toString();
    }

    @Override
    public void output() {

        if (DESTINATION.equals(result)) {
            log.info(result);
            log.info(RESULT.SUCCESS.toString());
        } else {
            log.info(RESULT.FAILURE.toString());
        }

    }
}
