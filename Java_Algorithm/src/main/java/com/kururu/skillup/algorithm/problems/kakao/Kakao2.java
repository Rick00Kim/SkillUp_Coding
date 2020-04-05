package com.kururu.skillup.algorithm.problems.kakao;

import com.google.common.collect.Sets;
import com.kururu.skillup.algorithm.AlgorithmIF;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h2>Dart Game</h2>
 * <ol>
 * <li>3 times for Dart game</li>
 * <li>Darts games consist of a total of three opportunities.</li>
 * <li>The score for each opportunity is from 0 to 10.</li>
 * <li>With scores, Single(S), Double(D), Triple(T) areas exist and are calculated from the score of 1 square, 2 square, 3 square (score ^1 , score ^2 , score ^3 ).</li>
 * <li>As an option, a star award (*) and a star award (#) exist, and the star award (*) winner doubles the score and the score just before.
 * If you win an Acha Prize (#), your score will be negative.</li>
 * <li>The Star Award can also come from the first opportunity. In this case, the score of the first star award (*) alone (See Example 4)</li>
 * <li>The effects of star awards (*) may overlap with those of other star awards (*). In this case, the nested Star Award (*) score is quadrupled. (See Example 4)</li>
 * <li>The effects of the Star Award (*) can overlap with the effects of the Acha Award (#). In this case, the scores of nested sub-chasants (#) are -2 times. (See Example 5)</li>
 * <li>Single(S), Double(D), and Triple(T) exist for each score.</li>
 * <li>A Star Award (*) or a Star Award (#) may exist or may not exist for each score.</li>
 * <li>Write a function that returns the total score when an integer from 0 to 10 and a string consisting of letters S, D, T, *, and # is entered.</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class Kakao2 implements AlgorithmIF {

    private static final Set<Pair<Integer, String>> TEST_LIST_PAIR_INPUT = Sets.newHashSet(
            Pair.of(37, "1S2D*3T"),
            Pair.of(9, "1D2S#10S"),
            Pair.of(3, "1D2S0T"),
            Pair.of(23, "1S*2T*3S"),
            Pair.of(5, "1D#2S*3S"),
            Pair.of(-4, "1T2D3D#"),
            Pair.of(59, "1D2S3T*")
    );

    private static final String INPUT = "1S#10D*3T";

    private static final String DESTINATION = "37";

    private String answer = null;

    public void input() {

    }

    public void process() {

        String regex = "(\\d{1,2}[S|T|D][*|#]{0,1})";

        final Pattern p = Pattern.compile(regex + regex + regex);

        final Matcher m = p.matcher(INPUT);

        m.find();

        for (int i = 1; i <= m.groupCount(); i++) {
            final Pattern p1 = Pattern.compile("(\\d{1,2})([S|T|D])([*|#]{0,1})");
            final Matcher m1 = p1.matcher(m.group(i));
            m1.find();

            m1.group(1);


        }

    }

    public void output() {

    }
}
