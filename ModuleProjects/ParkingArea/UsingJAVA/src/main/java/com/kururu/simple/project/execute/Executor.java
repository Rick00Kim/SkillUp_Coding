package com.kururu.simple.project.execute;

import static com.kururu.simple.project.constant.ParkingAreaConstants.ALL_FUNCTION_MAP;
import static com.kururu.simple.project.utility.common.CommonElements.USER_INPUT_READER;

import com.kururu.simple.project.controller.FunctionController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    @Autowired
    private FunctionController functionController;

    /**
     * Implements Method
     *
     * @param args Arguments
     * @throws Exception Exit with All Exception
     */
    @Override
    public void run(String... args) throws Exception {

        boolean isStop;
        do {
            showAllMenu();
            log.info("\nINPUT -> ");
            isStop = functionController.forwardFunction(USER_INPUT_READER.readLine());
        } while (!isStop);

    }

    /**
     * Output All Function
     */
    public void showAllMenu() {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n=======================");
        ALL_FUNCTION_MAP.forEach((k, v) -> stringBuffer.append(String.format("\n %s : %s", v.getLeft(), v.getValue())));
        stringBuffer.append("\n=======================");
        log.info(stringBuffer.toString());
    }

}
