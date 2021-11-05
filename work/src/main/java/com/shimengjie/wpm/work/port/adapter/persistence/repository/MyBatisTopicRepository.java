package com.shimengjie.wpm.work.port.adapter.persistence.repository;

import com.shimengjie.wpm.work.domain.model.topic.Topic;
import com.shimengjie.wpm.work.domain.model.topic.TopicRepository;
import com.shimengjie.wpm.work.port.adapter.persistence.repository.mapper.TopicMapper;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 17:45
 **/
@Component
public class MyBatisTopicRepository implements TopicRepository {

    @Resource
    private TopicMapper topicMapper;

    @Override
    public Topic topicOfId(Long id) {
        return topicMapper.selectByPrimaryKey(id);
    }
}
