package com.kururu.simple.project.service;

import static com.kururu.simple.project.constant.ParkingAreaEnums.KINDS_INCOME_INFORMATION;
import static com.kururu.simple.project.constant.ParkingAreaEnums.END_BUSINESS_FLG;

import com.google.common.collect.Lists;
import com.kururu.simple.project.constant.KururuFileProperties;
import com.kururu.simple.project.dto.CreateIncomeDto;
import com.kururu.simple.project.entity.EntryBook;
import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.repository.condition.BusinessStatusCondition;
import com.kururu.simple.project.utility.common.DateComponent;
import com.kururu.simple.project.utility.common.DateFormat;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

/**
 * <h2>Parking Area [Income Service]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Service
@Slf4j
public class IncomeService {

    private static final String CSV_FORMAT = "%s_%s.csv";

    @Autowired
    private EntryBookRepository entryBookRepository;

    @Autowired
    private DateComponent dateComponent;

    @Resource
    private KururuFileProperties kururuFileProperties;

    /**
     * Check Validation Dto(About value)
     *
     * @param createIncomeDto Target Dto
     * @return Check Result
     */
    public boolean validateDto(CreateIncomeDto createIncomeDto) {

        if (createIncomeDto.getKindsIncomeInformation() == KINDS_INCOME_INFORMATION.CUSTOM) {
            final Pair<String, String> targetPair = createIncomeDto.getPairDateRangeString();
            if (ObjectUtils.isEmpty(targetPair)) {
                return true;
            } else {
                final String dateRangeFrom = targetPair.getLeft().length() != 8 ? targetPair.getLeft() + "01"
                        : targetPair.getLeft();
                final String dateRangeTo = ObjectUtils.isEmpty(targetPair.getRight()) ? null
                        : targetPair.getRight().length() != 8 ? targetPair.getRight() + "01" : targetPair.getRight();

                try {
                    DateFormat.FORMAT_YYYYMMDD.parse(dateRangeFrom);
                    if (!ObjectUtils.isEmpty(dateRangeTo)) {
                        DateFormat.FORMAT_YYYYMMDD.parse(dateRangeTo);
                    }
                } catch (ParseException e) {
                    log.error("It is not correct Date type(FROM).", e);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Create Income Information
     *
     * @param createIncomeDto IncomeDto
     * @throws Exception All Exception
     */
    public void createIncomeInformation(CreateIncomeDto createIncomeDto) throws Exception {
        checkDirectories();
        final Path targetPath = getTargetPath(createIncomeDto);

        try {
            List<EntryBook> outputList = entryBookRepository.selectEntryBookAboutBusiness(createIncomeFileCondition(createIncomeDto));
            try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(targetPath.toFile()),
                    CSVFormat.DEFAULT.withSkipHeaderRecord())) {
                for (EntryBook entryBook : outputList) {
                    csvPrinter.printRecord(
                            createIncomeDto.getLotInformation().getLotNumber(),
                            createIncomeDto.getLotInformation().getLotName(),
                            entryBook.getKey().getVehicleNumber(),
                            entryBook.getKey().getClientNumber(),
                            entryBook.getCarSize(),
                            entryBook.getArrivalTime(),
                            entryBook.getDepartureTime(),
                            entryBook.getHoursOfUse(),
                            entryBook.getCostOfUse()
                    );
                    entryBook.setEndBusinessFlg(END_BUSINESS_FLG.BUSINESS_ENDED);
                    entryBookRepository.save(entryBook);
                }
            } catch (IOException ioe) {
                log.error("Failed to create income file");
            }
        } catch (Exception e) {
            log.error("Failed to get output", e);
            throw new Exception("Failed to get output", e);
        }
    }

    /**
     * Check Existing directories<br/>
     * If not exist, Create directories
     */
    private void checkDirectories() {
        try {
            if (!Files.exists(Paths.get(kururuFileProperties.getBaseDir()))) {
                Files.createDirectories(Paths.get(kururuFileProperties.getBaseDir()));
            }
            if (!Files.exists(Paths.get(kururuFileProperties.getDailyDir()))) {
                Files.createDirectories(Paths.get(kururuFileProperties.getDailyDir()));
            }
            if (!Files.exists(Paths.get(kururuFileProperties.getCustomDir()))) {
                Files.createDirectories(Paths.get(kururuFileProperties.getCustomDir()));
            }
        } catch (IOException ioe) {
            log.error("Failed create Directories", ioe);
        }
    }

    /**
     * Get target path
     *
     * @param createIncomeDto createIncomeDto
     * @return Target Path
     */
    private Path getTargetPath(CreateIncomeDto createIncomeDto) {
        switch (createIncomeDto.getKindsIncomeInformation()) {
            case FOR_DAY:
                return Paths.get(kururuFileProperties.getDailyDir(),
                        String.format(CSV_FORMAT, createIncomeDto.getLotInformation().getLotName(),
                                DateFormat.FORMAT_YYYYMMDD.format(dateComponent.getCurrentDate())));

            case CUSTOM:
                return Paths.get(kururuFileProperties.getCustomDir(),
                        String.format(CSV_FORMAT, createIncomeDto.getLotInformation().getLotName(),
                                DateFormat.FORMAT_YYYYMMDDHHMMSS.format(dateComponent.getCurrentDate())));

            default:
                throw new AssertionError("Not Expected value : " + createIncomeDto.getKindsIncomeInformation());
        }
    }

    /**
     * Create Income File Condition
     *
     * @param createIncomeDto createIncomeDto
     * @return incomeFileCondition
     * @throws Exception All Exception
     */
    private BusinessStatusCondition createIncomeFileCondition(CreateIncomeDto createIncomeDto) throws Exception {

        final Pair<Timestamp, Timestamp> targetDateRange = createIncomeDto.getKindsIncomeInformation() == KINDS_INCOME_INFORMATION.FOR_DAY ?
                dateComponent.getDateTermADay() : dateComponent.getDateTermADay(createIncomeDto.getPairDateRangeString());

        return BusinessStatusCondition.builder()
                .lotNumber(createIncomeDto.getLotInformation().getLotNumber())
                .pairTermADay(targetDateRange)
                .endBusinessFlgList(Lists.newArrayList(END_BUSINESS_FLG.BUSINESS_NOT_ENDED))
                .build();
    }
}
