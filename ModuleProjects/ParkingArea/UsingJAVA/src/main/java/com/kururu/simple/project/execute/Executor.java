package com.kururu.simple.project.execute;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Implements Method
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("MainExecutor is not support yet...");

    }
}
