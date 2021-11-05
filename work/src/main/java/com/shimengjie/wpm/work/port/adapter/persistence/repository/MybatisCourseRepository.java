package com.shimengjie.wpm.work.port.adapter.persistence.repository;

import com.shimengjie.wpm.work.domain.model.course.Course;
import com.shimengjie.wpm.work.domain.model.course.CourseRepository;
import com.shimengjie.wpm.work.port.adapter.persistence.repository.mapper.CourseMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 17:38
 **/
@Component
public class MybatisCourseRepository implements CourseRepository {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public Course courseOfId(Long id) {
        return courseMapper.selectByPrimaryKey(id);
    }
}
