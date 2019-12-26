package com.kururu.skillup.module.model;

import com.kururu.skillup.module.constant.SkillUpEnums;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "SU_ENTITY")
@SequenceGenerator(name = "SEQ_SKILLUP_GENERATOR", sequenceName = "SEQ_SKILLUP", initialValue = 1, allocationSize = 1)
public class SkillUpEntity extends CommonEntity {

    @Builder
    public SkillUpEntity(Timestamp insTs, String insName, Timestamp updTs, String updName, Long version, Long id, SkillUpEnums.KINDS kinds, String contents, Integer quantity, SkillUpEnums.DEL_FLG delFlg) {
        super(insTs, insName, updTs, updName, version);
        this.id = id;
        this.kinds = kinds;
        this.contents = contents;
        this.quantity = quantity;
        this.delFlg = delFlg;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SKILLUP_GENERATOR")
    private Long id;

    @Convert(converter = SkillUpEnums.KINDS.Convert.class)
    private SkillUpEnums.KINDS kinds;

    private String contents;

    private Integer quantity;

    @Convert(converter = SkillUpEnums.DEL_FLG.Convert.class)
    private SkillUpEnums.DEL_FLG delFlg;

}
