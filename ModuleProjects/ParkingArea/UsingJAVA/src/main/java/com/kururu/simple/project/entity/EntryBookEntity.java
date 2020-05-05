package com.kururu.simple.project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * <h2>Parking Area [Entity of ENTRY_BOOK]</h2>
 * <p>Entry book of parking lot</p>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class EntryBookEntity {

    /* Vehicle number */
    @Id
    private String vehicleNumber;

    /* Client number */
    @Column
    private String clientNumber;

    /* Arrival time */
    @Column
    private Timestamp arrivalTime;

    /* Departure time */
    @Column
    private Timestamp departureTime;

    /* Hours of use */
    @Column
    private Integer hoursOfUse;

    /* Cost of use */
    @Column
    private Integer costOfUse;

    /* End business flag */
    @Column
    private String endBusinessFlg;

}
