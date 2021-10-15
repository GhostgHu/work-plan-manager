package com.shimengjie.wpm.work.domain.model.activity;

import java.util.Collection;
import java.util.List;

/**
 * @author shimengjie
 * @date 2021/9/22 17:17
 **/
public interface ActivityWorkRepository {

    /**
     * 根据标题查询活动作品ID列表
     *
     * @param title 标题
     * @return List<Long>
     */
    List<Long> queryActivityWorkIdListByTitle(String title);

    /**
     * 根据ID集合查询作品列表
     *
     * @param ids ID集合
     * @return 作品列表
     */
    List<ActivityWork> queryActivityWorkListByIds(Collection<Long> ids);
}
