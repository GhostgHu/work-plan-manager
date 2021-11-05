package com.shimengjie.wpm.user.domain.model.admin;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import java.time.LocalDateTime;

public class AdminUser {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 管理员姓名
     */
    private String name;
    /**
     * 管理员手机号
     */
    private String phone;
    /**
     * 管理员邮箱
     */
    private String mail;

    /**
     * 是否已删除
     */
    private Boolean isDeleted;
    /**
     * 管理员角色,0-超管,1-普通管理员
     */
    private Integer role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public String getName() {
        return name;
    }
}
