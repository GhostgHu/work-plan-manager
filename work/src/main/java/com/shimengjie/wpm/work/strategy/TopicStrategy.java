package com.shimengjie.wpm.work.strategy;

import com.shimengjie.wpm.work.constant.IWork;
import com.shimengjie.wpm.work.domain.model.topic.TopicRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 17:25
 **/
@Component
public class TopicStrategy implements WorkStrategy {

    @Resource
    private TopicRepository topicRepository;

    @Override
    public String getType() {
        return IWork.Type.TOPIC;
    }

    @Override
    public boolean isExisted(Long id) {
        return topicRepository.topicOfId(id) != null;
    }
}
