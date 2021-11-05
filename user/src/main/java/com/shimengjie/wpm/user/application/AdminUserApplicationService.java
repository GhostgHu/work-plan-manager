package com.shimengjie.wpm.user.application;

import com.shimengjie.wpm.user.domain.model.admin.AdminUser;
import com.shimengjie.wpm.user.port.adapter.persistence.repository.MybatisAdminUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 16:29
 **/
@Service
public class AdminUserApplicationService {

    @Resource
    private MybatisAdminUserRepository mybatisAdminUserRepository;

    /**
     * 根据 id 查询管理员信息
     *
     * @param id 用户id
     * @return AdminUser
     */
    public AdminUser queryById(Long id) {
        if (id == null) {
            return null;
        }
        return mybatisAdminUserRepository.adminUserOfId(id, "id", "name", "phone");
    }
}
