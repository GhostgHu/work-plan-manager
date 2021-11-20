package com.shimengjie.wpm.dept.domain.model.dept;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shimengjie
 * @date 2021/11/20 20:33
 **/
@Getter
public class DeptDTO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("父级部门 ID")
    private Long parentId;

    @ApiModelProperty("组织名称")
    private String name;

    @ApiModelProperty("级别")
    private Integer level;

    private LocalDateTime createdAt;

    @ApiModelProperty("下级部门列表")
    private List<DeptDTO> childDeptList;

    public DeptDTO() {
        this.childDeptList = new LinkedList<>();
    }

    public DeptDTO(Dept organization) {
        this();
        BeanUtils.copyProperties(organization, this);
    }

    /**
     * 添加子级部门
     *
     * @param dto 子级部门
     */
    public void addChildOrganization(DeptDTO dto) {
        this.childDeptList.add(dto);
    }
}
