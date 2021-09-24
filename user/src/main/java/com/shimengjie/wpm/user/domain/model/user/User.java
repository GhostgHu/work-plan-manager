package com.shimengjie.wpm.user.domain.model.user;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 用户表 user_info
 *
 * @author shimengjie
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String name;

    private String phone;

    private String mail;

    private String appleId;

    private String qq;

    private String weixin;

    private String weibo;

    private Integer gender;

    private Integer area;

    private String headPicUrl;

    private String sign;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getAppleId() {
        return appleId;
    }

    public String getQq() {
        return qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public String getWeibo() {
        return weibo;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getArea() {
        return area;
    }

    public String getHeadPicUrl() {
        return "https://academy.fp.ps.netease.com/file/" + headPicUrl;
    }

    public String getSign() {
        return sign;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
