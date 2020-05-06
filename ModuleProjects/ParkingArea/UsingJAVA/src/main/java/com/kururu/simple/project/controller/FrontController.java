package com.kururu.simple.project.controller;

import com.kururu.simple.project.function.FunctionIF;
import org.springframework.util.ObjectUtils;

import java.io.BufferedReader;

/**
 * <h2>Parking Area [Front controller]</h2>
 * <ol>
 *     <li>Request selected Function Object from Main</li>
 *     <li>Transmit to Function class with BufferedReader</li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class FrontController {

    /**
     * Request for processing
     */
    public void processRequest(
            final FunctionIF functionIF,
            final BufferedReader bufferedReader
    ) {
        if (ObjectUtils.isEmpty(functionIF)) {
            return;
        }
        functionIF.execute(bufferedReader);
    }
}
