package com.shimengjie.wpm.user.domain.model.admin;

/**
 * @author shimengjie
 * @date 2021/9/22 17:17
 **/
public interface AdminUserRepository {

    /**
     * 更新 user 对象的非空字段
     *
     * @param adminUser 要更新的对象
     */
    void updateByPrimaryKeySelective(AdminUser adminUser);

    /**
     * 根据 ID 查询 adminUser 对象
     *
     * @param id         id
     * @param properties 要查询的字段值
     * @return AdminUser
     */
    AdminUser adminUserOfId(Long id, String... properties);
}
