package com.shimengjie.wpm.authority.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author shimengjie
 * @date 2021/9/23 20:14
 **/
@Configuration
@MapperScan("com.shimengjie.wpm.authority.port.adapter.persistence.repository.mapper")
public class MyBatisConfig {
}
