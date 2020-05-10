package com.kururu.simple.project.entity;

import static com.kururu.simple.project.constant.ParkingAreaEnums.DEL_FLG;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * <h2>Parking Area [Entity of LOT_INFORMATION]</h2>
 * <p>Area information by Parking lot</p>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "LOT_INFORMATION")
public class LotInformation {

    /* Lot number(Sequence) */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long lotNumber;

    /* Lot name */
    @Column(nullable = false)
    private String lotName;

    /* Acceptable small car */
    @Column(nullable = false)
    private Integer acceptableSmall;

    /* Acceptable medium car */
    @Column(nullable = false)
    private Integer acceptableMedium;

    /* Acceptable heavy car */
    @Column(nullable = false)
    private Integer acceptableHeavy;

    /* Delete flag (Using Converter) */
    @NotNull
    @Convert(converter = DEL_FLG.Convert.class)
    private DEL_FLG delFlg;
}
