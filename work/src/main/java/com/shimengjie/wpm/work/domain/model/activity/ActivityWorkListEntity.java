package com.shimengjie.wpm.work.domain.model.activity;

import com.shimengjie.wpm.common.utils.CollectionUtil;
import com.shimengjie.wpm.work.domain.model.activity.query.ActivityWorkListQuery;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author shimengjie
 * @date 2021/10/15 14:56
 **/
public class ActivityWorkListEntity {

    private ActivityWorkListQuery activityWorkListQuery;

    private int total;

    private List<ActivityWork> activityWorkList;

    public ActivityWorkListEntity() {
    }

    public ActivityWorkListEntity(ActivityWorkListQuery activityWorkListQuery) {
        this.activityWorkListQuery = activityWorkListQuery;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ActivityWork> getActivityWorkList() {
        return this.activityWorkList;
    }

    public void setActivityWorkList(List<ActivityWork> activityWorkList) {
        this.activityWorkList = activityWorkList;
    }

    /**
     * 打乱 id 列表
     */
    public void shuffleIdList(List<Long> idList) {
        if (CollectionUtil.isEmpty(idList)) {
            return;
        }
        Collections.shuffle(idList, new Random(activityWorkListQuery.getSeed()));
    }

    /**
     * 分页 idList
     */
    public List<Long> pagingIdList(List<Long> idList) {
        return CollectionUtil.pagingList(idList, activityWorkListQuery.getPageNum(), activityWorkListQuery.getPageSize());
    }


}
