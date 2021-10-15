package com.shimengjie.wpm.common.utils;

/**
 * @author shimengjie
 * @date 2021/10/15 15:19
 **/
public class MathUtils {

    /**
     * 分页显示时，计算页数
     *
     * @param total    总记录数
     * @param pageSize 每页记录数
     */
    public static int computePageNum(Integer total, Integer pageSize) {
        return (total % pageSize == 0) ? (total / pageSize) : (total / pageSize + 1);
    }
}
