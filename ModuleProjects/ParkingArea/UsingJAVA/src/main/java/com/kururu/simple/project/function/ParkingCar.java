package com.kururu.simple.project.function;

import com.kururu.simple.project.entity.LotInformation;
import com.kururu.simple.project.repository.LotInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.util.List;

/**
 * <h2>Parking Area [Park new car to free area]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Slf4j
public class ParkingCar implements FunctionIF {

    @Autowired
    private LotInformationRepository lotInformationRepository;

    @Override
    public void execute(final BufferedReader bufferedReader) {
        final List<LotInformation> list = lotInformationRepository.findAll();
        log.info(list.toString());

    }

}
