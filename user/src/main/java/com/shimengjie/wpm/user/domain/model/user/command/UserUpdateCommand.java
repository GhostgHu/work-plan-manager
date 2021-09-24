package com.shimengjie.wpm.user.domain.model.user.command;

/**
 * @author shimengjie
 * @date 2021/9/22 17:41
 **/
public class UserUpdateCommand {

    private String name;

    private String mail;

    private Integer gender;

    private String headPicUrl;

    private String sign;

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public Integer getGender() {
        return gender;
    }

    public String getHeadPicUrl() {
        return headPicUrl;
    }

    public String getSign() {
        return sign;
    }
}
