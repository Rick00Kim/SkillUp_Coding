package com.kururu.simple.project.utility.common;


import java.text.SimpleDateFormat;

/**
 * <h2>Parking Area [Date Formatters]</h2>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class DateFormat {

    /**
     * Date Format : yyyyMMdd
     */
    public static final SimpleDateFormat FORMAT_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

    /**
     * Date Format : yyyyMMddHHmmss
     */
    public static final SimpleDateFormat FORMAT_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * Date Format : yyyy/MM/dd
     */
    public static final SimpleDateFormat FORMAT_YYYYMMDD_WITH_SLASH = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * Date Format : yyyy/MM/dd HH:mm:ss
     */
    public static final SimpleDateFormat FORMAT_YYYYMMDD_WITH_SLASH_TIME = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

}
