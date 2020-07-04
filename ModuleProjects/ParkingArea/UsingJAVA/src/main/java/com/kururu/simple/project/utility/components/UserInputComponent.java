package com.kururu.simple.project.utility.components;

import com.kururu.simple.project.utility.common.ParkingAreaEnumInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * <h2>Parking Area [User Input Component]</h2>
 * <ol>
 *     <li>User Input Reader</li>
 *     <li>Output prompt</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class UserInputComponent {

    /* User Input Reader */
    private final BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Output String and get user input
     *
     * @param outputString output on prompt
     * @return User Input
     */
    public String getUserInput(String outputString) {
        try {
            log.info("\n" + outputString);
            return userInputReader.readLine();
        } catch (IOException ioe) {
            log.error("It has some problem when getting USER INPUT", ioe);
            return null;
        }
    }

    /**
     * Output Enums and get user input
     *
     * @param outputEnum Target Enum array for output
     * @return User Input
     */
    public <T extends Enum<T> & ParkingAreaEnumInterface<E>, E> String getUserInput(Class<T> outputEnum) {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("\n");
            Stream.of(outputEnum.getEnumConstants())
                    .forEach(e -> sb.append(String.format("%10s -> %s\n", e.getDescription(), e.getCode())));
            sb.append(" -> ");
            log.info(sb.toString());
            return userInputReader.readLine();
        } catch (IOException ioe) {
            log.error("It has some problem when getting USER INPUT", ioe);
            return null;
        }
    }


}
