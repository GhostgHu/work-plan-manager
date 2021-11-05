package com.shimengjie.wpm.user.port.adapter.persistence.repository;

import com.shimengjie.wpm.user.domain.model.admin.AdminUser;
import com.shimengjie.wpm.user.domain.model.admin.AdminUserRepository;
import com.shimengjie.wpm.user.port.adapter.persistence.repository.mapper.AdminUserMapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/11/5 16:24
 **/
@Component
public class MybatisAdminUserRepository implements AdminUserRepository {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public void updateByPrimaryKeySelective(AdminUser adminUser) {
        adminUserMapper.updateByPrimaryKeySelective(adminUser);
    }

    @Override
    public AdminUser adminUserOfId(Long id, String... properties) {
        Example example = new Example(AdminUser.class);
        if (properties != null && properties.length > 0) {
            example.selectProperties(properties);
        }
        example.createCriteria().andEqualTo("id", id);
        return adminUserMapper.selectOneByExample(example);
    }
}
