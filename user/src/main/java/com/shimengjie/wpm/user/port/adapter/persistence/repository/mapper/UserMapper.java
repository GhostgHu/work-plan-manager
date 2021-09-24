package com.shimengjie.wpm.user.port.adapter.persistence.repository.mapper;

import com.shimengjie.wpm.common.port.adapter.persistence.repository.mapper.WpmMapper;
import com.shimengjie.wpm.user.domain.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author shimengjie
 * @date 2021/9/22 17:21
 **/
@Component
public interface UserMapper extends WpmMapper<User> {


    /**
     * 根据 id 查询用户信息
     *
     * @param id     用户id
     * @param fields 查询的字段
     * @return UserInfo
     */
    @Select("SELECT #{fields} FROM user WHERE id = #{id}")
    User userOfId(@Param("id") Long id,  String fields);

}
