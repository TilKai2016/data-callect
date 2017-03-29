package com.tilkai.client.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author tilkai
 */
public class DateUtil {

    /**
     * 时间字符串转Calendar
     * @param dateStr 时间字符串
     * @param format 格式化
     * @return Calendar
     * @throws ParseException
     */
    public static Calendar dateStr2Calendar(String dateStr, String format) throws ParseException {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(dateStr2Date(dateStr, format));

        return calendar;
    }

    /**
     * 时间字符串转Date
     * @param dateStr
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date dateStr2Date(String dateStr, String format) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.parse(dateStr);
    }
}
