package com.kururu.simple.project.entity;

import static com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * <h2>Parking Area [Entity of ENTRY_BOOK]</h2>
 * <p>Entry book of parking lot</p>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ENTRY_BOOK")
public class EntryBook {

    @EmbeddedId
    private EntryBookIdentity key;

    /* Arrival time */
    @NotNull
    @Column
    private Timestamp arrivalTime;

    /* Departure time */
    @Column
    private Timestamp departureTime;

    /* Hours of use */
    @Max(99)
    @Column
    private Integer hoursOfUse;

    /* Cost of use */
    @Max(999999999)
    @Column
    private Integer costOfUse;

    /* End business flag (Using Converter) */
    @Convert(converter = END_BUSINESS_FLG.Convert.class)
    private END_BUSINESS_FLG endBusinessFlg;

}
