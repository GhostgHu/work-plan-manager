package com.shimengjie.wpm.work.domain.model.topic;

/**
 * @author shimengjie
 * @date 2021/9/22 17:17
 **/
public interface TopicRepository {

    /**
     * 根据ID查询 Topic
     *
     * @param id ID
     * @return News
     */
    Topic topicOfId(Long id);

}
