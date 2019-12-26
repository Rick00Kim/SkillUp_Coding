
CREATE TABLE SU_ENTITY
(
    "ID" NUMBER NOT NULL ENABLE,
    "KINDS" VARCHAR2 (2 BYTE) NOT NULL ENABLE,
    "CONTENTS" VARCHAR2 (50 BYTE),
    "QUANTITY" NUMBER (10),
    "DEL_FLG" CHAR(1 BYTE) NOT NULL ENABLE,
    "INS_TS" TIMESTAMP NOT NULL ENABLE,
    "INS_NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
    "UPD_TS" TIMESTAMP NOT NULL ENABLE,
    "UPD_NAME" VARCHAR2(100 BYTE) NOT NULL ENABLE,
	"VERSION" LONG NOT NULL ENABLE,
	 PRIMARY KEY ("ID")
);