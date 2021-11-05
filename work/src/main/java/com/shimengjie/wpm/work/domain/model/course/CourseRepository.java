package com.shimengjie.wpm.work.domain.model.course;

/**
 * @author shimengjie
 * @date 2021/9/22 17:17
 **/
public interface CourseRepository {

    /**
     * 根据ID查询 课程
     *
     * @param id ID
     * @return Course
     */
    Course courseOfId(Long id);

}
