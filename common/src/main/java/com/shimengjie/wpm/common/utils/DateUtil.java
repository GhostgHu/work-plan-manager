package com.shimengjie.wpm.common.utils;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author shimengjie
 * @date 2021/11/10 16:39
 **/
@Data
public class DateUtil {

    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_FORMAT_WITH_MILLI = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 将{@linkplain Date} 转换成{@linkplain LocalDateTime}
     *
     * @param date Date 对象
     * @return LocalDateTime 对象
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * LocalDateTime 对象转成秒时间戳
     *
     * @param time LocalDateTime 对象
     * @return 秒时间戳
     */
    public static long localDateTime2Second(LocalDateTime time) {
        return time.toEpochSecond(ZoneOffset.of("+8"));
    }

    /**
     * LocalDateTime 对象转成毫秒时间戳
     *
     * @param time LocalDateTime 对象
     * @return 毫秒时间戳
     */
    public static long localDateTime2MillSecond(LocalDateTime time) {
        return time.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 时间戳转换成LocalDateTime
     *
     * @param timestamp 毫秒时间戳
     */
    public static LocalDateTime millsToDatetime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

}
