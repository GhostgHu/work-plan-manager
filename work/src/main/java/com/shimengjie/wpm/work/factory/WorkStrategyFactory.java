package com.shimengjie.wpm.work.factory;

import com.shimengjie.wpm.common.annotation.RegistryStrategyFactory;
import com.shimengjie.wpm.common.factory.StrategyFactory;
import com.shimengjie.wpm.common.strategy.Strategy;
import com.shimengjie.wpm.work.strategy.WorkStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shimengjie
 * @date 2021/11/5 14:40
 **/
@Component
@RegistryStrategyFactory(strategy = WorkStrategy.class)
public class WorkStrategyFactory implements StrategyFactory<String> {

    /**
     * 保存 WorkStrategy 实例
     */
    private Map<String, WorkStrategy> map;

    public WorkStrategyFactory() {
        this.map = new HashMap<>();
    }

    @Override
    public void addStrategy(String k, Strategy<String> v) {
        map.put(k, (WorkStrategy) v);
    }

    @Override
    public WorkStrategy getByType(String key) {
        return map.get(key);
    }

}
