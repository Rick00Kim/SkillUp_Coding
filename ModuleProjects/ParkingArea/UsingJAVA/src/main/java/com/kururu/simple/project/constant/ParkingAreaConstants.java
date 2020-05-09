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
    public static final Map<String, String> ALL_FUNCTION_MAP = Collections.unmodifiableMap(new HashMap<String, String>() {
        private static final long serialVersionUID = 1L;

        {
            put("1", "ParkCar");
            put("2", "ExitCar");
            put("3", "ViewUsage");
            put("4", "IncomeCreate");
            put("5", "EndBusiness");
            put("6", "ExitProgram");
            put("100", "Menu");
        }
    });

}
