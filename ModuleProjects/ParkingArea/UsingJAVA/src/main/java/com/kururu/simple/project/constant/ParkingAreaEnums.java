package com.kururu.simple.project.constant;

import com.kururu.simple.project.utility.common.ParkingAreaEnumInterface;
import com.kururu.simple.project.utility.db.ParkingAreaEnumsConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * <h2>Parking Area [Enums]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class ParkingAreaEnums {

    /**
     * Menu show flag
     */
    @AllArgsConstructor
    @Getter
    public enum MENU_SHOW_FLG implements ParkingAreaEnumInterface<String> {
        BASICALLY_SHOW("0", "Show menu basically"),
        NECESSARY_CURRENT_LOT("1", "Show when Existing current lot");

        private final String code;
        private final String description;

    }

    /**
     * Delete Flag
     */
    @AllArgsConstructor
    @Getter
    public enum DEL_FLG implements ParkingAreaEnumInterface<String> {
        NOT_DELETED("0", "Not Deleted"),
        DELETED("1", "Deleted");
        private final String code;

        private final String description;

        public static class Convert extends ParkingAreaEnumsConverter<DEL_FLG, String> {
            public Convert() {
                super(DEL_FLG.class);
            }
        }

    }

    /**
     * End business Flag
     */
    @AllArgsConstructor
    @Getter
    public enum END_BUSINESS_FLG implements ParkingAreaEnumInterface<String> {
        BUSINESS_NOT_ENDED("0", "Not ended business"),
        BUSINESS_ENDED("1", "Ended business");
        private final String code;

        private final String description;

        public static class Convert extends ParkingAreaEnumsConverter<END_BUSINESS_FLG, String> {
            public Convert() {
                super(END_BUSINESS_FLG.class);
            }
        }

    }

    /**
     * Car Size
     */
    @AllArgsConstructor
    @Getter
    public enum CAR_SIZE implements ParkingAreaEnumInterface<String> {
        SMALL("0", "Small size car"),
        MEDIUM("1", "Medium size car"),
        HEAVY("2", "Heavy size car");
        private final String code;

        private final String description;

        public static class Convert extends ParkingAreaEnumsConverter<CAR_SIZE, String> {
            public Convert() {
                super(CAR_SIZE.class);
            }

        }

        public static CAR_SIZE getValue(final String code) {
            return Stream.of(CAR_SIZE.values())
                    .filter(e -> code.equals(e.getCode()))
                    .findFirst()
                    .orElse(null);
        }

    }
}
