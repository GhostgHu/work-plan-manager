package com.shimengjie.wpm.authority.domain.model.commonauthority.cache;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.shimengjie.wpm.authority.domain.model.commonauthority.CommonAuthority;
import com.shimengjie.wpm.authority.port.adapter.persistence.repository.MybatisCommonAuthorityRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shimengjie
 * @date 2021/9/23 21:01
 **/
@Component
public class CommonAuthorityCacheLoader implements CacheLoader<String, CommonAuthority> {

    @Resource
    private MybatisCommonAuthorityRepository mybatisCommonAuthorityRepository;

    @Override
    public CommonAuthority load(String key) {
        return mybatisCommonAuthorityRepository.queryOfOperateType(key);
    }

}
