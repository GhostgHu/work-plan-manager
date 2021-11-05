package com.shimengjie.wpm.common.strategy;

/**
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
