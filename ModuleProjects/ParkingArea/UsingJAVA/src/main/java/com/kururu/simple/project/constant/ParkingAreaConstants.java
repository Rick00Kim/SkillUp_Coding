package com.kururu.simple.project.constant;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <h2>Parking Area [Constants]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class ParkingAreaConstants {

    /**
     * Function Map
     */
    public static final Map<Integer, Pair<String, String>> ALL_FUNCTION_MAP = Collections.unmodifiableMap(new HashMap<Integer, Pair<String, String>>() {
        private static final long serialVersionUID = 1L;

        {
            put(1, Pair.of("1", "ParkCar"));
            put(2, Pair.of("2", "ExitCar"));
            put(3, Pair.of("3", "ViewUsage"));
            put(4, Pair.of("4", "IncomeCreate"));
            put(5, Pair.of("5", "EndBusiness"));
            put(6, Pair.of("6", "ExitProgram"));
        }
    });

}
