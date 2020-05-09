package com.kururu.simple.project.entity;

import com.kururu.simple.project.constant.ParkingAreaEnums;
import lombok.*;

import javax.persistence.*;

/**
 * <h2>Parking Area [Entity of LOT_INFORMATION]</h2>
 * <p>Area information by Parking lot</p>
 *
 * @author Rick00Kim d
 * @Getter
 * @Setter
 * @Entity(name = "LOT_INFORMATION")reamx119@gmail.com
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
    @Column
    private String lotName;

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
