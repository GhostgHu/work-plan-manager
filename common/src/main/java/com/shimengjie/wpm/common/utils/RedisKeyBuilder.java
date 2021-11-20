package com.shimengjie.wpm.common.utils;


/**
 * RedisKey创建工具
 *
 * @Author: wengguangyao
 * @Date: 2019/3/28 11:34
 */
public class RedisKeyBuilder {

    private final String REDIS_KEY_SEPARATOR = ":";

    private String moduleName;

    public RedisKeyBuilder(String moduleName) {
        this.moduleName = moduleName;
    }

    /**
     * 创建RedisKey
     *
     * @param businessName 业务名
     * @param dataName     数据名
     * @param params       参数
     * @return KEY
     */
    public String buildKey(String businessName, String dataName, Object... params) {
        StringBuilder sb = new StringBuilder(moduleName);
        sb.append(REDIS_KEY_SEPARATOR);
        sb.append(businessName);
        sb.append(REDIS_KEY_SEPARATOR);
        sb.append(dataName);
        if (params != null && params.length > 0) {
            sb.append(REDIS_KEY_SEPARATOR);
            for (Object param : params) {
                sb.append(param);
                sb.append(REDIS_KEY_SEPARATOR);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
