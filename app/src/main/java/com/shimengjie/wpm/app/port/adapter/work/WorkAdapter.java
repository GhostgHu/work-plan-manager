package com.shimengjie.wpm.app.port.adapter.work;

import com.shimengjie.wpm.work.application.WorkApplicationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 17:56
 **/
@Component
public class WorkAdapter {

    @Resource
    private WorkApplicationService workApplicationService;

    /**
     * 点赞作品
     *
     * @param type 作品类型
     * @param id   作品ID
     */
    public void like(String type, Long id) {
        workApplicationService.like(type,id);
    }
}
