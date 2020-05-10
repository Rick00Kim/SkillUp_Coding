package com.kururu.simple.project.function;

import com.kururu.simple.project.repository.EntryBookRepository;
import com.kururu.simple.project.repository.LotInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <h2>Parking Area [Park new car to free area]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
@Slf4j
public class ParkingCar extends AbstractFunction {

    @Autowired
    private LotInformationRepository lotInformationRepository;

    @Autowired
    private EntryBookRepository entryBookRepository;

    @Override
    protected void inputAndValidate() {

    }

    @Override
    protected void process() {

    }
}
