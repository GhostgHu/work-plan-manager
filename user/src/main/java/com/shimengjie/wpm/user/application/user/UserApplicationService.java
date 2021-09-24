package com.shimengjie.wpm.user.application.user;

import com.shimengjie.wpm.user.domain.model.user.User;
import com.shimengjie.wpm.user.domain.model.user.UserEntity;
import com.shimengjie.wpm.user.domain.model.user.command.UserUpdateCommand;
import com.shimengjie.wpm.user.port.adapter.persistence.repository.MybatisUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/9/22 17:39
 **/
@Service
public class UserApplicationService {

    @Resource
    private MybatisUserRepository mybatisUserInfoRepository;

    public void updateById(Long id, UserUpdateCommand command) {
        User user = this.queryById(id);

        UserEntity entity = new UserEntity(user, command);
        entity.changeUser();

        mybatisUserInfoRepository.updateByPrimaryKeySelective(user);
    }


    /**
     * 根据 id 查询用户信息
     *
     * @param id 用户id
     * @return UserInfo
     */
    public User queryById(Long id) {
        if (id == null) {
            return null;
        }
        return mybatisUserInfoRepository.userOfId(id, "id", "name", "headPicUrl", "sign");
    }

}
