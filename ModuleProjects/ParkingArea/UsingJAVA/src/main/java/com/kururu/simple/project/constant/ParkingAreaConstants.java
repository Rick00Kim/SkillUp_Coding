package com.kururu.simple.project.constant;

import com.kururu.simple.project.constant.ParkingAreaEnums.MENU_SHOW_FLG;

import org.apache.commons.lang3.tuple.Triple;

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
    public static final Map<Integer, Triple<String, String, MENU_SHOW_FLG>> ALL_FUNCTION_MAP
            = Collections.unmodifiableMap(new HashMap<Integer, Triple<String, String, MENU_SHOW_FLG>>() {
        private static final long serialVersionUID = 1L;

        {
            put(1, Triple.of("1", "ParkCar", MENU_SHOW_FLG.BASICALLY_SHOW));
            put(2, Triple.of("2", "ExitCar", MENU_SHOW_FLG.BASICALLY_SHOW));
            put(3, Triple.of("3", "ViewUsage", MENU_SHOW_FLG.BASICALLY_SHOW));
            put(4, Triple.of("4", "IncomeCreate", MENU_SHOW_FLG.BASICALLY_SHOW));
            put(5, Triple.of("5", "EndBusiness", MENU_SHOW_FLG.BASICALLY_SHOW));
            put(6, Triple.of("6", "ExitProgram", MENU_SHOW_FLG.BASICALLY_SHOW));
            put(11, Triple.of("11", "Current Lot Change", MENU_SHOW_FLG.NECESSARY_CURRENT_LOT));
        }
    });

    /* Format of warn message(NOT NULL) */
    public static final String WARN_MESSAGE_NOT_NULL = "%s should not be null";

    /* Format of warn message(INPUT ERROR) */
    public static final String WARN_MESSAGE_INPUT_ERROR = "Not correct input -> %s";
}
