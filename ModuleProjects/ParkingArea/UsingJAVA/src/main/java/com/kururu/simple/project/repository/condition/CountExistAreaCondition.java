package com.kururu.simple.project.repository.condition;

import static com.kururu.simple.project.constant.ParkingAreaEnums.CAR_SIZE;

import lombok.*;
import org.apache.commons.lang3.tuple.Pair;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <h2>Parking Area [JPA condition Object]</h2>
 *
 * <ol>
 *     <li>{@link com.kururu.simple.project.repository.EntryBookRepository#countExistEmptyArea(CountExistAreaCondition)}</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountExistAreaCondition implements Serializable {

    /* Lot Number */
    private Long lotNumber;

    /* Car Size */
    private CAR_SIZE carSize;

    /* Term Pair(Before, After) */
    private Pair<Timestamp, Timestamp> pairTermADay;

}
