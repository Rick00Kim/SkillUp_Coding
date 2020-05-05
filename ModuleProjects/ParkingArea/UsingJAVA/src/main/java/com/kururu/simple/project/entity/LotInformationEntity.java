package com.kururu.simple.project.entity;

import com.kururu.simple.project.constant.ParkingAreaEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * <h2>Parking Area [Entity of LOT_INFORMATION]</h2>
 * <p>Area information by Parking lot</p>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class LotInformationEntity {

    /* Lot number(Sequence) */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long LotNumber;

    /* Lot name */
    @Column
    private String LotName;

    /* Acceptable small car */
    @Column
    private Integer acceptableSmall;

    /* Acceptable medium car */
    @Column
    private Integer acceptableMedium;

    /* Acceptable heavy car */
    @Column
    private Integer acceptableHeavy;

    /* Delete flag (Using Converter) */
    @Convert(converter = ParkingAreaEnums.DEL_FLG.Convert.class)
    private ParkingAreaEnums.DEL_FLG delFlg;
}
