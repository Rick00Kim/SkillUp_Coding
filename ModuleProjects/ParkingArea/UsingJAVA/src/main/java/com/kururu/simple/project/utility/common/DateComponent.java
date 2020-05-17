package com.kururu.simple.project.utility.common;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * <h2>Parking Area [Component about Date]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
public class DateComponent {

    public Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public Date getCurrentDate() {
        return new Date();
    }

    public Pair<Timestamp, Timestamp> getDateTermADay() {
        final Date currentDate = getCurrentDate();
        final Timestamp beforeDate = new Timestamp(DateUtils.truncate(getCurrentDate(), Calendar.DAY_OF_MONTH).getTime());
        Date afterDate = DateUtils.truncate(currentDate, Calendar.DAY_OF_MONTH);
        afterDate = DateUtils.addDays(afterDate, 1);
        afterDate = DateUtils.addSeconds(afterDate, -1);
        return Pair.of(beforeDate, new Timestamp(afterDate.getTime()));
    }
}
