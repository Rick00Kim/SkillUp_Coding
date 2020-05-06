package com.kururu.simple.project.execute;

import static com.kururu.simple.project.constant.ParkingAreaConstants.ALL_FUNCTION_MAP;

import com.kururu.simple.project.controller.FrontController;
import com.kururu.simple.project.function.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * <h2>Parking Area [Module Starter]</h2>
 * <ol>
 *     <li>Using CommandLineRunner</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class Executor implements CommandLineRunner {

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Implements Method
     *
     * @param args Arguments
     * @throws Exception Exit with All Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("MainExecutor is not support yet...");

        boolean isStop = false;
        final FrontController frontController = new FrontController();
        showAllMenu();
        do {
            log.info("\nINPUT -> ");
            final String clientInput = selectFunction(bufferedReader.readLine());
            FunctionIF functionIF = null;
            switch (clientInput) {
                case "1":
                    functionIF = new ParkingCar();
                    break;
                case "2":
                    functionIF = new ExitingCar();
                    break;
                case "3":
                    functionIF = new ViewUsageState();
                    break;
                case "4":
                    functionIF = new CreateIncomeInformation();
                    break;
                case "5":
                    functionIF = new EndOfBusiness();
                    break;
                case "6":
                    log.info("Exit Program....");
                    isStop = true;
                    break;
                case "100":
                    showAllMenu();
                    break;
                default:
                    log.info("Incorrect input...");
                    break;
            }

            frontController.processRequest(functionIF, bufferedReader);

        } while (!isStop);

    }

    private void showAllMenu() {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n=======================");
        ALL_FUNCTION_MAP.forEach((k, v) -> stringBuffer.append(String.format("\n %s : %s", k, v)));
        stringBuffer.append("\n=======================");
        log.info(stringBuffer.toString());

    }

    private String selectFunction(
            final String userInput
    ) {
        if (ObjectUtils.isEmpty(userInput)) {
            return StringUtils.EMPTY;
        }
        for (Map.Entry<String, String> mapEntry : ALL_FUNCTION_MAP.entrySet()) {
            if (mapEntry.getKey().equals(userInput)) {
                return mapEntry.getKey();
            } else {
                if (mapEntry.getValue().toLowerCase().equals(userInput.toLowerCase())) {
                    return mapEntry.getKey();
                }
            }
        }
        return userInput;
    }
}
