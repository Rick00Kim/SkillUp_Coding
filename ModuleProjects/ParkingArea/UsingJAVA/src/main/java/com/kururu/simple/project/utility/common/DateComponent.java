package com.kururu.simple.project.utility.common;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * <h2>Parking Area [Component about Date]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
@Component
public class DateComponent {

    private static final String DATE_FINAL = "99991231";

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

    public Pair<Timestamp, Timestamp> getDateTermADay(Pair<String, String> customDatePair) throws ParseException {

        final Timestamp beforeDate = new Timestamp(DateFormat.FORMAT_YYYYMMDD.parse(customDatePair.getLeft().length() == 8
                ? customDatePair.getLeft() : customDatePair.getLeft() + "01").getTime());

        Date finishDate = DateFormat.FORMAT_YYYYMMDD.parse(ObjectUtils.isEmpty(customDatePair.getRight()) ?
                DATE_FINAL : customDatePair.getRight().length() == 8 ?
                customDatePair.getRight() : customDatePair.getRight() + "01");
        finishDate = DateUtils.truncate(finishDate, Calendar.DAY_OF_MONTH);
        finishDate = DateUtils.addDays(finishDate, 1);
        finishDate = DateUtils.addSeconds(finishDate, -1);

        return Pair.of(beforeDate, new Timestamp(finishDate.getTime()));
    }


}
