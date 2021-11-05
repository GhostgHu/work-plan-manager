package com.shimengjie.wpm.work.config;

import com.shimengjie.wpm.common.annotation.RegistryStrategyFactory;
import com.shimengjie.wpm.common.factory.StrategyFactory;
import com.shimengjie.wpm.common.strategy.Strategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;

import java.util.Map;

/**
 * @author shimengjie
 * @date 2021/11/5 14:54
 **/
@Configuration
public class StrategyConfig implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 找出注册的 StrategyFactory
        for (StrategyFactory factory : applicationContext.getBeansOfType(StrategyFactory.class).values()) {
            RegistryStrategyFactory annotation = AnnotationUtils.findAnnotation(factory.getClass(), RegistryStrategyFactory.class);
            if (annotation != null) {
                // 取出注解中指定的 策略 Bean
                Class<? extends Strategy> strategyClazz = annotation.strategy();
                Map<String, ? extends Strategy> map = applicationContext.getBeansOfType(strategyClazz);
                for (Strategy value : map.values()) {
                    factory.addStrategy(value.getType(), value);
                }
            }
        }
    }


}
