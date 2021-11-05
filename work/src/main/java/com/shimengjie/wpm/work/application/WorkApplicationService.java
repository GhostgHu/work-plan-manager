package com.shimengjie.wpm.work.application;

import com.shimengjie.wpm.common.exception.NotFoundException;
import com.shimengjie.wpm.work.factory.WorkStrategyFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 17:58
 **/
@Service
public class WorkApplicationService {

    @Resource
    private WorkStrategyFactory workStrategyFactory;

    /**
     * 点赞作品
     *
     * @param type 作品类型
     * @param id   作品ID
     */
    public void like(String type, Long id) {
        boolean isExisted = workStrategyFactory.getByType(type).isExisted(id);
        if (!isExisted) {
            throw new NotFoundException();
        }
        // TODO 点赞
    }
}
