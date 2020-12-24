package com.kururu.skillup.algorithm.problems.kakao;

import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;

/**
 * 1 "[\"#####\",\"# # #\",\"### #\",\"#  ##\",\"#####\"]"
 * 2 "[\"######\",\"### #\",\"## ##\",\" #### \",\" #####\",\"### # \"]"
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Kakao1 implements AlgorithmIF {

    /* INPUT */
    private static final int N = 5;
    private int[] inputArray1 = null;
    private int[] inputArray2 = null;

    /* ASSERT */
    private static final String DESTINATION = "[\"#####\",\"# # #\",\"### #\",\"#  ##\",\"#####\"]";

    private String result = null;

    public void input() {

        inputArray1 = new int[]{9, 20, 28, 18, 11};
        inputArray2 = new int[]{30, 1, 21, 17, 28};

    }

    public void process() {

        String[] process = new String[N];

        for (int i = 0; i < N; i++) {
            String raw = Integer.toBinaryString(inputArray1[i] | inputArray2[i]);
            raw = raw.replace("1", "#");
            raw = raw.replace("0", " ");
            process[i] = raw;
        }

        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < N; i++) {
            sb.append("\"");
            sb.append(process[i]);
            sb.append("\"");
            if (i != process.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        result = sb.toString();

    }

    public void output() {
        if (result.equals(DESTINATION)) {
            log.info(RESULT.SUCCESS.toString());
            log.info(result);
        } else {
            log.info(RESULT.FAILURE.toString());
        }
    }
}
