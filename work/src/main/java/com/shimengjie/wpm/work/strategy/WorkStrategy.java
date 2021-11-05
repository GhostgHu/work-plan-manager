package com.shimengjie.wpm.work.strategy;

import com.shimengjie.wpm.common.strategy.Strategy;

/**
 * @author shimengjie
 * @date 2021/11/5 14:40
 **/
public interface WorkStrategy extends Strategy<String> {

    /**
     * 判断作品是否存在
     *
     * @param id 作品ID
     * @return true/false
     */
    boolean isExisted(Long id);

}
