package com.shimengjie.wpm.user.domain.model.user;

/**
 * @author shimengjie
 * @date 2021/9/22 17:17
 **/
public interface UserRepository {

    /**
     * 更新 user 对象的非空字段
     *
     * @param user 要更新的对象
     */
    void updateByPrimaryKeySelective(User user);

    /**
     * 根据 ID 查询 userInfo 对象
     *
     * @param id         id
     * @param properties 要查询的字段值
     * @return UserInfo
     */
    User userOfId(Long id, String... properties);
}
