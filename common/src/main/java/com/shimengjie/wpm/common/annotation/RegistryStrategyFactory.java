package com.shimengjie.wpm.common.annotation;

import com.shimengjie.wpm.common.strategy.Strategy;

import java.lang.annotation.*;

/**
 * @author shimengjie
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RegistryStrategyFactory {

    /**
     * 指定策略实现类
     */
    Class<? extends Strategy> strategy();
}
