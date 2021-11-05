package com.shimengjie.wpm.work.strategy;

import com.shimengjie.wpm.work.constant.IWork;
import com.shimengjie.wpm.work.domain.model.news.NewsRepository;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 16:34
 **/
@Component
public class NewsStrategy implements WorkStrategy {

    @Resource
    private NewsRepository newsRepository;

    @Override
    public String getType() {
        return IWork.Type.NEWS;
    }


    @Override
    public boolean isExisted(Long id) {
        return newsRepository.newsOfId(id) != null;
    }
}
