package com.shimengjie.wpm.common.utils;

/**
 * @author shimengjie
 * @date 2021/10/15 14:52
 **/
public class StringUtils {

    /**
     * 判断字符串是否为空
     *
     * @param cs 字符串
     * @return true/false
     */
    public static Boolean isBlank(CharSequence cs) {
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

}
