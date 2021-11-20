package com.shimengjie.wpm.dept.domain.model.dept;


import java.time.LocalDateTime;
import javax.persistence.Table;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import tk.mybatis.mapper.annotation.KeySql;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author author, auto generated on 2021-11-20
 */
@Getter
public class Dept {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 父级ID
     */
    private Long parentId;
    /**
     * 等级，从1开始
     */
    private Integer level;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
