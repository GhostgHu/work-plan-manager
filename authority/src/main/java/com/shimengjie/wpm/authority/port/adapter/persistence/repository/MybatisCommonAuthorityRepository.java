package com.shimengjie.wpm.authority.port.adapter.persistence.repository;

import com.shimengjie.wpm.authority.domain.model.commonauthority.CommonAuthority;
import com.shimengjie.wpm.authority.domain.model.commonauthority.CommonAuthorityRepository;
import com.shimengjie.wpm.authority.port.adapter.persistence.repository.mapper.CommonAuthorityMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/9/23 20:15
 **/
@Component
public class MybatisCommonAuthorityRepository implements CommonAuthorityRepository {

    @Resource
    private CommonAuthorityMapper commonAuthorityMapper;

    @Override
    public CommonAuthority queryOfOperateType(String operateType) {
        return commonAuthorityMapper.selectOne(new CommonAuthority(operateType));
    }
}
