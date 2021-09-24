package com.shimengjie.wpm.common.port.adapter.persistence.repository.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author shimengjie
 * @date 2021/9/22 17:23
 **/
@RegisterMapper
public interface WpmMapper<T> extends Mapper<T>, InsertListMapper<T> {

    /**
     * 解析传入的字段
     *
     * @param properties 传入的要查询的字段
     * @return sql 语句
     */
    default String parseProperties(String... properties) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        if (properties != null && properties.length > 0) {
            for (String property : properties) {
                sb.append(property).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append("*");
        }
        sb.append(" ");
        return sb.toString();
    }
}
