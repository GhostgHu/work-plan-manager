package com.shimengjie.wpm.work.strategy;

import com.shimengjie.wpm.work.constant.IWork;
import com.shimengjie.wpm.work.port.adapter.persistence.repository.MybatisCourseRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 16:06
 **/
@Component
public class CourseStrategy implements WorkStrategy {

    @Resource
    private MybatisCourseRepository mybatisCourseRepository;

    @Override
    public String getType() {
        return IWork.Type.COURSE;
    }

    @Override
    public boolean isExisted(Long id) {
        return mybatisCourseRepository.courseOfId(id) != null;
    }
}
