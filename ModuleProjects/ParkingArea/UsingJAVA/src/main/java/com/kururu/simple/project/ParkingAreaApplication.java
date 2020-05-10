package com.kururu.simple.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <h2>Parking Area Executor</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@SpringBootApplication
@EnableJpaRepositories
public class ParkingAreaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingAreaApplication.class, args);
    }

}
