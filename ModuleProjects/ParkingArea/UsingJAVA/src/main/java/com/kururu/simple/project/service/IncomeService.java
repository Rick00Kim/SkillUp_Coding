package com.kururu.simple.project.service;

import static com.kururu.simple.project.constant.ParkingAreaEnums.KINDS_INCOME_INFORMATION;

import com.kururu.simple.project.constant.KururuFileProperties;
import com.kururu.simple.project.dto.CreateIncomeDto;
import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.repository.LotInformationRepository;
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
import java.text.ParseException;

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
                final String dateRangeFrom = targetPair.getLeft().length() != 8 ?
                        targetPair.getLeft() + "01" : targetPair.getLeft();
                final String dateRangeTo = ObjectUtils.isEmpty(targetPair.getRight()) ?
                        null : targetPair.getRight().length() != 8 ?
                        targetPair.getRight() + "01" : targetPair.getRight();

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

    public void createIncomeInformation(CreateIncomeDto createIncomeDto) {
        checkDirectories();
        final Path targetPath = getTargetPath(createIncomeDto);

        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(targetPath.toFile()),
                CSVFormat.DEFAULT.withSkipHeaderRecord())) {
            csvPrinter.printRecord("we", "are", "the", "TEST1");
        } catch (IOException ioe) {
            log.error("Failed to create income file");
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
                        String.format(CSV_FORMAT,
                                createIncomeDto.getLotInformation().getLotName(),
                                DateFormat.FORMAT_YYYYMMDD.format(dateComponent.getCurrentDate())));

            case CUSTOM:
                return Paths.get(kururuFileProperties.getCustomDir(),
                        String.format(CSV_FORMAT,
                                createIncomeDto.getLotInformation().getLotName(),
                                DateFormat.FORMAT_YYYYMMDDHHMMSS.format(dateComponent.getCurrentDate())));

            default:
                throw new AssertionError("Not Expected value : "
                        + createIncomeDto.getKindsIncomeInformation());
        }
    }
}
