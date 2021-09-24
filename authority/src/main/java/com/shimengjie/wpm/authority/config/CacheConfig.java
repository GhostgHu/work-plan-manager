package com.shimengjie.wpm.authority.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.shimengjie.wpm.authority.domain.model.commonauthority.CommonAuthority;
import com.shimengjie.wpm.authority.domain.model.commonauthority.cache.CommonAuthorityCacheLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author shimengjie
 * @date 2021/9/23 21:46
 **/
@Configuration
public class CacheConfig {

    @Bean
    public LoadingCache<String, CommonAuthority> commonAuthorityCache(CommonAuthorityCacheLoader cacheLoader) {
        return Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build(cacheLoader);
    }
}
