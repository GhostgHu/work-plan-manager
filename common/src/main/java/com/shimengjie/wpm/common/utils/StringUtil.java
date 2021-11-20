package com.shimengjie.wpm.common.utils;

import java.util.UUID;

/**
 * @author shimengjie
 * @date 2021/10/15 14:52
 **/
public class StringUtil {

    /**
     * 判断字符串是否为空
     *
     * @param cs 字符串
     * @return true/false
     */
    public static Boolean isBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    public static Boolean isNotBlank(final CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(cs);
    }


    public static String randomGUID() {
        UUID uuid = UUID.randomUUID();
        long mostSigBits = uuid.getMostSignificantBits();
        long leastSigBits = uuid.getLeastSignificantBits();
        return (digits(mostSigBits >> 32, 8) + digits(mostSigBits >> 16, 4) + digits(mostSigBits, 4)
                + digits(leastSigBits >> 48, 4) + digits(leastSigBits, 12));
    }

    private static String digits(long val, int digits) {
        long hi = 1L << (digits * 4);
        return Long.toHexString(hi | (val & (hi - 1))).substring(1);
    }

}
