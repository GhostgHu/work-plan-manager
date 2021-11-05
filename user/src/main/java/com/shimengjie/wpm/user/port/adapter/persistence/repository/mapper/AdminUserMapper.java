package com.shimengjie.wpm.user.port.adapter.persistence.repository.mapper;

import com.shimengjie.wpm.common.port.adapter.persistence.repository.mapper.WpmMapper;
import com.shimengjie.wpm.user.domain.model.admin.AdminUser;
import org.springframework.stereotype.Component;

/**
 * @author shimengjie
 * @date 2021/11/5 16:25
 **/
@Component
public interface AdminUserMapper extends WpmMapper<AdminUser> {
}
