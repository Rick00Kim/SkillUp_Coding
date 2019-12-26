package com.kururu.skillup.module.constant;

import com.kururu.skillup.module.utility.convert.SkillUpEnumsConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class SkillUpEnums {

    @AllArgsConstructor
    @Getter
    public enum DEL_FLG implements EnumInterface<String> {
        NOT_DELETED("0", "Not Deleted"),
        DELETED("1", "Deleted");

        private String code;
        private String description;

        public static class Convert extends SkillUpEnumsConverter<DEL_FLG, String> {
            public Convert() {
                super(DEL_FLG.class);
            }
        }
    }

    @AllArgsConstructor
    @Getter
    public enum KINDS implements EnumInterface<String> {
        NEW("01", "New Data"),
        ADD("02", "Add Date"),
        UPDATE("03", "Update Data"),
        DELETE("04", "Delete Data");

        private String code;
        private String description;

        public static class Convert extends SkillUpEnumsConverter<KINDS, String> {
            public Convert() {
                super(KINDS.class);
            }
        }
    }
}
