package com.shimengjie.wpm.work.application;

import com.shimengjie.wpm.work.domain.model.activity.ActivityWork;
import com.shimengjie.wpm.work.domain.model.activity.ActivityWorkListEntity;
import com.shimengjie.wpm.work.domain.model.activity.query.ActivityWorkListQuery;
import com.shimengjie.wpm.work.port.adapter.persistence.repository.MybatisActivityWorkRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shimengjie
 * @date 2021/10/14 20:53
 **/
@Service
public class ActivityWorkApplicationService {

    @Resource
    private MybatisActivityWorkRepository mybatisActivityWorkRepository;

    /**
     * 查询活动作品列表
     *
     * @param activityWorkListQuery 查询条件
     * @return List<ActivityWork>
     */
    public ActivityWorkListEntity queryActivityWorkList(ActivityWorkListQuery activityWorkListQuery) {
        ActivityWorkListEntity entity = new ActivityWorkListEntity(activityWorkListQuery);
        // 查询满足条件的作品ID
        List<Long> idList = mybatisActivityWorkRepository.queryActivityWorkIdListByTitle(activityWorkListQuery.getTitle());
        entity.setTotal(idList.size());
        entity.shuffleIdList(idList);
        // 分页后查询
        List<Long> subList = entity.pagingIdList(idList);
        List<ActivityWork> list = mybatisActivityWorkRepository.queryActivityWorkListByIds(subList);
        entity.setActivityWorkList(list);
        return entity;
    }
}
