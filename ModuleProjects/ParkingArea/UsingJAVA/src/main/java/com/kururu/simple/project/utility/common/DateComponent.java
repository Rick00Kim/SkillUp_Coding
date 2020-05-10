package com.kururu.simple.project.utility.common;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class DateComponent {

    public Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public Date getCurrentDate() {
        return new Date();
    }
}
