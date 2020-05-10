package com.kururu.simple.project.constant;

import com.kururu.simple.project.utility.common.ParkingAreaEnumInterface;
import com.kururu.simple.project.utility.db.ParkingAreaEnumsConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <h2>Parking Area [Enums]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class ParkingAreaEnums {

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

}
