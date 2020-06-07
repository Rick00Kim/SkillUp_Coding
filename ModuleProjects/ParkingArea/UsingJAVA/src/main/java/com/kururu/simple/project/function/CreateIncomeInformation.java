package com.kururu.simple.project.function;

import static com.kururu.simple.project.constant.ParkingAreaEnums.KINDS_INCOME_INFORMATION;

import com.kururu.simple.project.constant.KururuFileProperties;
import com.kururu.simple.project.dto.CreateIncomeDto;
import com.kururu.simple.project.service.IncomeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <h2>Parking Area [Create income information]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class CreateIncomeInformation extends AbstractFunction {

    private static final String TARGET_INCOME_DTO = "targetIncomeDto";

    @Autowired
    private IncomeService incomeService;

    @Override
    protected RESULT_STATUS input() {

        try {
            final CreateIncomeDto createIncomeDto = CreateIncomeDto.builder()
                    .kindsIncomeInformation(
                            Objects.requireNonNull(
                                    KINDS_INCOME_INFORMATION.getValue(
                                            userInputComponent.getUserInput(KINDS_INCOME_INFORMATION.class))
                            ))
                    .lotInformation(currentLotInformation)
                    .build();
            if (createIncomeDto.getKindsIncomeInformation() == KINDS_INCOME_INFORMATION.CUSTOM) {
                createIncomeDto.setPairDateRangeString(
                        Pair.of(
                                userInputComponent.getUserInput("Date Range(From) -> "),
                                userInputComponent.getUserInput("Date Range(To)   -> ")
                        )
                );
            }
            functionMap.put(TARGET_INCOME_DTO, createIncomeDto);
        } catch (Exception e) {
            log.error("Not Expected error", e);
            return RESULT_STATUS.FAILURE;
        }
        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS validate() {

        final CreateIncomeDto targetCreateIncomeDto = (CreateIncomeDto) functionMap.get(TARGET_INCOME_DTO);
        if (incomeService.validateDto(targetCreateIncomeDto)) {
            return RESULT_STATUS.FAILURE;
        }

        return RESULT_STATUS.SUCCESS;
    }

    @Override
    public RESULT_STATUS process() {
        try {
            incomeService.createIncomeInformation((CreateIncomeDto) functionMap.get(TARGET_INCOME_DTO));
        } catch (Exception e) {
            log.error("It has problem when Create Income Information", e);
            return RESULT_STATUS.FAILURE;
        }

        return RESULT_STATUS.SUCCESS;
    }

}
