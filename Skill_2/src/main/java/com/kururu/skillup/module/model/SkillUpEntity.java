package com.kururu.skillup.module.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SU_ENTITY")
public class SkillUpEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "KINDS")
    private String kinds;

    @Column(name = "CONTENTS")
    private String contents;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "DEL_FLG")
    private String delFlg;

    @Column(name = "INS_TS")
    private Timestamp insTs;

    @Column(name = "INS_NAME")
    private String insName;

    @Column(name = "UPD_TS")
    private Timestamp updTs;

    @Column(name = "UPD_NAME")
    private String updName;

    @Column(name = "VERSION")
    private Long version;
}
