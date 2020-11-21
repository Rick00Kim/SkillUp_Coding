package com.kururu.simple.project.function;

import static com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;

import com.google.common.collect.Lists;
import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.repository.condition.BusinessStatusCondition;
import com.kururu.simple.project.utility.common.DateComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <h2>Parking Area [End of Business]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class EndOfBusiness extends AbstractFunction {

    private static final String TARGET_ENTRY_BOOK_LIST = "targetEntryBookList";

    @Autowired
    private EntryBookRepository entryBookRepository;

    @Autowired
    private DateComponent dateComponent;

    @Override
    protected RESULT_STATUS input() {
        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS validate() {
        /* Get target list of validate */
        final List<EntryBook> entryBookList
                = entryBookRepository.selectEntryBookAboutBusiness(BusinessStatusCondition.builder()
                .lotNumber(currentLotInformation.getLotNumber())
                .pairTermADay(dateComponent.getDateTermADay())
                .endBusinessFlgList(Lists.newArrayList(END_BUSINESS_FLG.values()))
                .build()
        );
        /* Validate */
        if (!CollectionUtils.isEmpty(entryBookList)) {
            entryBookList.forEach(e -> log.warn(String.format("Vehicle Number[%s] is not ended. please check", e.getKey().getVehicleNumber())));
            return RESULT_STATUS.FAILURE;
        }

        functionMap.put(TARGET_ENTRY_BOOK_LIST, entryBookList);

        return RESULT_STATUS.SUCCESS;
    }

    @Override
    public RESULT_STATUS process() {
        return RESULT_STATUS.SUCCESS;
    }

}
