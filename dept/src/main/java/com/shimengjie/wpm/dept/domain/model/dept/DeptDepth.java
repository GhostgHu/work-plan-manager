package com.shimengjie.wpm.dept.domain.model.dept;


import java.time.LocalDateTime;
import javax.persistence.Table;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import tk.mybatis.mapper.annotation.KeySql;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author author, auto generated on 2021-11-20
 */
@Data
public class DeptDepth {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    /**
     * 祖先节点ID
     */
    private Long ancestorId;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 深度
     */
    private Integer depth;
    private LocalDateTime createdAt;
}
