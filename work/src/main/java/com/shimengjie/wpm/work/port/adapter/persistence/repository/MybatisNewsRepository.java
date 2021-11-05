package com.shimengjie.wpm.work.port.adapter.persistence.repository;

import com.shimengjie.wpm.work.domain.model.news.News;
import com.shimengjie.wpm.work.domain.model.news.NewsRepository;
import com.shimengjie.wpm.work.port.adapter.persistence.repository.mapper.NewsMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 17:43
 **/
@Component
public class MybatisNewsRepository implements NewsRepository {

    @Resource
    private NewsMapper newsMapper;

    @Override
    public News newsOfId(Long id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
