package com.kururu.skillup.algorithm.problems.codility;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

/**
 * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Codility1 implements AlgorithmIF {

    @Override
    public void input() {

    }

    @Override
    public void process() {

        int start = 1041;

        int maxGap = 0;
        int current = 0;
        int next = 0;
        while (start >= 1) {
            if (current != 0) {
                if (start % 2 == 1) {
                    int gap = (next++) - current - 1;
                    if (maxGap < gap) {
                        maxGap = gap;
                    }
                } else {
                    next++;
                }
            }
            current = next;
            start /= 2;
        }

        log.info("While : " + maxGap);


        log.info("Method Result : " + maxGap(start));
    }


    private int maxGap(int target) {
        StringBuilder sb = new StringBuilder();
        while (target >= 1) {
            sb.append(target % 2);
            target /= 2;
        }

        final String binary = sb.toString();

        int maxGap = 0;
        int ne;
        int cu = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.toCharArray()[i] == '1') {
                if (cu == 0) {
                    cu = i;
                }
                int gap = i - cu - 1;
                ne = i;
                cu = ne;
                if (maxGap < gap) {
                    maxGap = gap;
                }

            }
        }
        return maxGap;
    }

    @Override
    public void output() {

    }
}
