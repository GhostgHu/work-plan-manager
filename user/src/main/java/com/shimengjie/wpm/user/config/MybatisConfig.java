package com.shimengjie.wpm.user.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author shimengjie
 * @date 2021/9/22 19:12
 **/
@Configuration
@MapperScan("com.shimengjie.wpm.user.port.adapter.persistence.repository.mapper")
public class MybatisConfig {
}
