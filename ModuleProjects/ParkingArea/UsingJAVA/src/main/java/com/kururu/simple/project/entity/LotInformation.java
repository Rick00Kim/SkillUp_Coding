package com.kururu.simple.project.entity;

import static com.kururu.simple.project.constant.ParkingAreaEnums.DEL_FLG;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
public class LotInformation implements Serializable {

    /* Lot number(Sequence) */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LOT_NUMBER")
    private Long lotNumber;

    /* Lot name */
    @Column(name = "LOT_NAME",nullable = false)
    private String lotName;

    /* Acceptable small car */
    @Column(name = "ACCEPTABLE_SMALL",nullable = false)
    private Integer acceptableSmall;

    /* Acceptable medium car */
    @Column(name = "ACCEPTABLE_MEDIUM",nullable = false)
    private Integer acceptableMedium;

    /* Acceptable heavy car */
    @Column(name = "ACCEPTABLE_HEAVY",nullable = false)
    private Integer acceptableHeavy;

    /* Delete flag (Using Converter) */
    @NotNull
    @Column(name = "DEL_FLG")
    @Convert(converter = DEL_FLG.Convert.class)
    private DEL_FLG delFlg;
}
