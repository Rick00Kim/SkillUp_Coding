package com.kururu.simple.project.execute;

import static com.kururu.simple.project.constant.ParkingAreaConstants.ALL_FUNCTION_MAP;

import com.google.common.collect.Sets;
import com.kururu.simple.project.constant.ParkingAreaEnums.MENU_SHOW_FLG;
import com.kururu.simple.project.controller.FunctionController;
import com.kururu.simple.project.utility.components.UserInputComponent;
import com.kururu.simple.project.utility.factory.CurrentLotInformationFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

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

    @Autowired
    private CurrentLotInformationFactory currentLotInformationFactory;

    @Autowired
    private UserInputComponent userInputComponent;

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
            isStop = functionController.forwardFunction(
                    userInputComponent.getUserInput("INPUT -> "));
        } while (!isStop);
    }

    /**
     * Output usable Function
     */
    private void showAllMenu() {

        /* Set menu for showing. but setting current lot information, modify menu. */
        final Set<MENU_SHOW_FLG> setShowMenuTarget = Sets.newHashSet(MENU_SHOW_FLG.BASICALLY_SHOW);
        if (currentLotInformationFactory.isExistCurrentLotInformation()) {
            setShowMenuTarget.add(MENU_SHOW_FLG.NECESSARY_CURRENT_LOT);
        }

        /* Show menus */
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n=======================");
        ALL_FUNCTION_MAP.values().stream()
                .filter(v -> setShowMenuTarget.contains(v.getRight()))
                .forEach(v -> stringBuffer.append(String.format("\n %s : %s", v.getLeft(), v.getMiddle())));
        stringBuffer.append("\n=======================");
        log.info(stringBuffer.toString());
    }

}
