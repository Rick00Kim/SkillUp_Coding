package com.kururu.simple.project.function;

import com.google.common.collect.Maps;
import com.kururu.simple.project.constant.ParkingAreaEnums.CAR_SIZE;
import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.repository.condition.CountExistAreaCondition;
import com.kururu.simple.project.utility.common.DateComponent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Stream;

/**
 * <h2>Parking Area [View usage state]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class ViewUsageState extends AbstractFunction {

    private static final Map<CAR_SIZE, Pair<Integer, Integer>> COUNT_RESULT_MAP = Maps.newEnumMap(CAR_SIZE.class);

    private static final String PRINT_HEADER_FORMAT = "LOT Name : %s";
    private static final String PRINT_CONTENT_FORMAT = "%15s\t -> Max: %2d, Current: %2d";

    @Autowired
    private EntryBookRepository entryBookRepository;

    @Autowired
    private DateComponent dateComponent;

    @Override
    protected RESULT_STATUS input() {

        COUNT_RESULT_MAP.put(CAR_SIZE.SMALL, Pair.of(currentLotInformation.getAcceptableSmall(), 0));
        COUNT_RESULT_MAP.put(CAR_SIZE.MEDIUM, Pair.of(currentLotInformation.getAcceptableMedium(), 0));
        COUNT_RESULT_MAP.put(CAR_SIZE.HEAVY, Pair.of(currentLotInformation.getAcceptableHeavy(), 0));

        Stream.of(CAR_SIZE.values()).forEach(e -> {
            final Pair<Integer, Integer> valueOfMap = COUNT_RESULT_MAP.get(e);
            final int currentCount = entryBookRepository.countExistEmptyArea(CountExistAreaCondition.builder()
                    .lotNumber(currentLotInformation.getLotNumber())
                    .carSize(e)
                    .pairTermADay(dateComponent.getDateTermADay())
                    .build());
            COUNT_RESULT_MAP.put(e, Pair.of(valueOfMap.getLeft(), currentCount));
        });
        return RESULT_STATUS.SUCCESS;
    }

    @Override
    protected RESULT_STATUS validate() {
        if (COUNT_RESULT_MAP.size() != CAR_SIZE.values().length) {
            return RESULT_STATUS.FAILURE;
        }
        return RESULT_STATUS.SUCCESS;
    }

    @Override
    public RESULT_STATUS process() {
        log.info(String.format(PRINT_HEADER_FORMAT, currentLotInformation.getLotName()));
        COUNT_RESULT_MAP.forEach((k, v) -> log.info(String.format(PRINT_CONTENT_FORMAT, k.getDescription(), v.getLeft(), v.getRight())));
        return RESULT_STATUS.SUCCESS;
    }

}
