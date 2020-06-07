package com.kururu.simple.project.repository.condition;

import lombok.*;
import org.apache.commons.lang3.tuple.Pair;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <h2>Parking Area [JPA condition Object]</h2>
 *
 * <ol>
 *     <li>{@link com.kururu.simple.project.repository.EntryBookRepository#selectEntryBookForIncomeFile(IncomeFileCondition)}</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IncomeFileCondition implements Serializable {

    /* Lot Number */
    private Long lotNumber;

    /* Term Pair(Before, After) */
    private Pair<Timestamp, Timestamp> pairTermADay;

}
