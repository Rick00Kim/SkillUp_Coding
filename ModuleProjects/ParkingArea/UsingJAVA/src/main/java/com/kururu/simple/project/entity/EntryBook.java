package com.kururu.simple.project.entity;

import static com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;
import static com.kururu.simple.project.constant.ParkingAreaEnums.CAR_SIZE;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
public class EntryBook implements Serializable {

    @EmbeddedId
    private EntryBookIdentity key;

    /* Car size */
    @NotNull
    @Column(name = "CAR_SIZE")
    @Convert(converter = CAR_SIZE.Convert.class)
    private CAR_SIZE carSize;

    /* Arrival time */
    @NotNull
    @Column(name = "ARRIVAL_TIME")
    private Timestamp arrivalTime;

    /* Departure time */
    @Column(name = "DEPARTURE_TIME")
    private Timestamp departureTime;

    /* Hours of use */
    @Max(99)
    @Column(name = "HOURS_OF_USE")
    private Integer hoursOfUse;

    /* Cost of use */
    @Max(999999999)
    @Column(name = "COST_OF_USE")
    private Integer costOfUse;

    /* End business flag (Using Converter) */
    @Column(name = "END_BUSINESS_FLG")
    @Convert(converter = END_BUSINESS_FLG.Convert.class)
    private END_BUSINESS_FLG endBusinessFlg;

}
