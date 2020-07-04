package com.kururu.simple.project.dto;

import static com.kururu.simple.project.constant.ParkingAreaEnums.KINDS_INCOME_INFORMATION;

import com.kururu.simple.project.entity.LotInformation;
import lombok.*;
import org.apache.commons.lang3.tuple.Pair;

/**
 * <h2>Parking Area [DTO for Create Income Information function]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateIncomeDto {

    /* Kinds income */
    private KINDS_INCOME_INFORMATION kindsIncomeInformation;

    /* Target lot Number */
    private LotInformation lotInformation;

    /* Target Date Range Pair(Before, After) */
    private Pair<String, String> pairDateRangeString;

}
