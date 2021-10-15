package com.shimengjie.wpm.work.port.adapter.persistence.repository.mapper;

import com.shimengjie.wpm.common.port.adapter.persistence.repository.mapper.WpmMapper;
import com.shimengjie.wpm.work.domain.model.activity.ActivityWork;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shimengjie
 * @date 2021/9/22 17:21
 **/
@Component
public interface ActivityWorkMapper extends WpmMapper<ActivityWork> {

    @Select("SELECT id FROM activity_work WHERE title LIKE CONCAT('%',#{title},'%')")
    List<Long> queryActivityWorkIdsByTitle(@Param("title") String title);

    @Select("SELECT id FROM activity_work")
    List<Long> queryActivityWorkIds();
}
