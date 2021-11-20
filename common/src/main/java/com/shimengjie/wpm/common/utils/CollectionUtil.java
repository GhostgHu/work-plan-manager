package com.shimengjie.wpm.common.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author shimengjie
 * @date 2021/10/15 14:48
 **/
public class CollectionUtil {


    /**
     * 判断集合是否为空
     *
     * @param collection 集合
     * @return 空:true, 非空:false
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断集合是否非空
     *
     * @param collection 集合
     * @return 空:false, 非空:true
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 判断 map 是否为空
     *
     * @param map MAP
     * @return 空:true, 非空:false
     */
    public static boolean isMapEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * 根据分页参数，从总的数据集中找到所需的数据子集
     *
     * @param list     总列表
     * @param page     页码，从1开始
     * @param pageSize 每页数据量
     */
    public static <T> List<T> pagingList(List<T> list, Integer page, Integer pageSize) {
        int start = (page - 1) * pageSize;
        int offset = pageSize + start;
        int size = list.size();

        if (offset <= size) {
            return list.subList(start, offset);
        } else if (start < size) {
            return list.subList(start, size);
        } else {
            return new ArrayList<>();
        }
    }
}
