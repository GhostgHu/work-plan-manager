package com.shimengjie.wpm.app.port.adapter.work;

import com.shimengjie.wpm.work.application.ActivityWorkApplicationService;
import com.shimengjie.wpm.work.domain.model.activity.ActivityWorkListEntity;
import com.shimengjie.wpm.work.domain.model.activity.query.ActivityWorkListQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/10/14 21:30
 **/
@Component
public class ActivityWorkAdapter {

    @Resource
    private ActivityWorkApplicationService activityWorkApplicationService;

    public ActivityWorkListEntity queryActivityWorkList(ActivityWorkListQuery activityWorkListQuery) {
        return activityWorkApplicationService.queryActivityWorkList(activityWorkListQuery);
    }
}
