package com.kururu.simple.project.repository.condition;

import static com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;

import lombok.*;
import org.apache.commons.lang3.tuple.Pair;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * <h2>Parking Area [JPA condition Object]</h2>
 *
 * <ol>
 * <li>{@link com.kururu.simple.project.repository.EntryBookRepository#selectEntryBookAboutBusiness(BusinessStatusCondition)}</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessStatusCondition implements Serializable {

    private static final long serialVersionUID = 1L;

    /* Lot Number */
    private Long lotNumber;

    /* Term Pair(Before, After) */
    private Pair<Timestamp, Timestamp> pairTermADay;

    /* End Business Flag */
    private List<END_BUSINESS_FLG> endBusinessFlgList;

}
