package com.shimengjie.wpm.user.domain.model.user;

import com.shimengjie.wpm.user.domain.model.user.command.UserUpdateCommand;
import org.springframework.util.Assert;

/**
 * @author shimengjie
 * @date 2021/9/23 17:35
 **/
public class UserEntity {

    private User user;

    private UserUpdateCommand userUpdateCommand;

    public UserEntity() {
    }

    public UserEntity(User user, UserUpdateCommand userUpdateCommand) {
        this.user = user;
        this.userUpdateCommand = userUpdateCommand;
    }

    /**
     * 修改 user 对象
     */
    public void changeUser() {
        assertUserNotNull(this.user);
        assertUserUpdateCommandNotNull(this.userUpdateCommand);

        user.setGender(this.userUpdateCommand.getGender());
        user.setHeadPicUrl(this.userUpdateCommand.getHeadPicUrl());
        user.setMail(this.userUpdateCommand.getMail());
        user.setName(this.userUpdateCommand.getName());
        user.setSign(this.userUpdateCommand.getSign());
    }

    protected void assertUserNotNull(User user) {
        Assert.notNull(user, "user is null");
    }

    protected void assertUserUpdateCommandNotNull(UserUpdateCommand command) {
        Assert.notNull(command, "user update command is null");
    }
}
