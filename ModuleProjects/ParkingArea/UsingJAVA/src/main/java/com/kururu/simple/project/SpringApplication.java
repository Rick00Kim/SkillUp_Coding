package com.kururu.simple.project;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <h2>Parking Area Executor</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@SpringBootApplication
public class SpringApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
