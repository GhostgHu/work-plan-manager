package com.shimengjie.wpm.common.factory;

import com.shimengjie.wpm.common.strategy.Strategy;

/**
 * @author shimengjie
 * @date 2021/11/5 14:41
 **/
public interface StrategyFactory<K> {

    /**
     * 添加 Strategy 实例
     *
     * @param k Strategy 的类型
     * @param v Strategy 实例
     */
    void addStrategy(K k, Strategy<K> v);

    /**
     * 根据 key 值取出对应的 Strategy
     *
     * @param key Strategy 的类型
     * @return Strategy 实例
     */
    Strategy<K> getByType(K key);
}
