package com.shimengjie.wpm.app.port.adapter.user;

import com.shimengjie.wpm.user.application.UserApplicationService;
import com.shimengjie.wpm.user.domain.model.user.User;
import com.shimengjie.wpm.user.domain.model.user.command.UserUpdateCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/9/24 17:31
 **/
@Component
public class UserAdapter {

    @Resource
    private UserApplicationService userApplicationService;


    public void updateById(Long id, @RequestBody UserUpdateCommand command) {
        userApplicationService.updateById(id, command);
    }

    public User queryById(Long id) {
        return userApplicationService.queryById(id);
    }
}
