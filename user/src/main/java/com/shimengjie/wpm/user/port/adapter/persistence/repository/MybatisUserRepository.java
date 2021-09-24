package com.shimengjie.wpm.user.port.adapter.persistence.repository;

import com.shimengjie.wpm.user.domain.model.user.User;
import com.shimengjie.wpm.user.domain.model.user.UserRepository;
import com.shimengjie.wpm.user.port.adapter.persistence.repository.mapper.UserMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/9/22 17:29
 **/
@Service
public class MybatisUserRepository implements UserRepository {

    @Resource
    private UserMapper userMapper;

    @Override
    public void updateByPrimaryKeySelective(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User userOfId(Long id, String... properties) {
        Example example = new Example(User.class);
        if (properties != null && properties.length > 0) {
            example.selectProperties(properties);
        }
        example.createCriteria().andEqualTo("id", id);
        return userMapper.selectOneByExample(example);
    }
}
