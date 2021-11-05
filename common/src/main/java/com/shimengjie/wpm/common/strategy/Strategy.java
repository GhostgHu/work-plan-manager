package com.shimengjie.wpm.common.strategy;

/**
 * 泛型 Strategy 接口
 *
 * @author shimengjie
 * @date 2021/11/5 14:39
 **/
public interface Strategy<K> {

    /**
     * 返回类型
     *
     * @return K
     */
    K getType();
}
