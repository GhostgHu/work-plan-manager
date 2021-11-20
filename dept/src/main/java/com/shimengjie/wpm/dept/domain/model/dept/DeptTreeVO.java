package com.shimengjie.wpm.dept.domain.model.dept;


import com.shimengjie.wpm.common.domain.Assert;
import com.shimengjie.wpm.common.exception.ParamException;

import java.util.*;

/**
 *  Tree 对象
 *
 * @author shimengjie
 * @date 2021/11/12 17:03
 **/
public class DeptTreeVO extends Assert {

    /**
     * 父级部门 map
     */
    private Map<Long, DeptDTO> parentMap;

    /**
     * 结果列表
     */
    private List<DeptDTO> list;

    public DeptTreeVO() {
        this.list = new LinkedList<>();
    }

    /**
     * 根据部门 map 和 对应的深度列表，构建 DeptList 对象
     *
     * @param map       部门map
     * @param depthList 对应的深度列表，按照 depth DESC 排序
     */
    public DeptTreeVO(Map<Long, Dept> map, List<DeptDepth> depthList) {
        this();

        super.notEmpty(depthList, "传入的部门深度 list 不能为空");
        super.notEmpty(map, "传入的部门 map 不能为空");
        super.sizeEqual(map.size(), depthList.size(), "部门 map、深度 list 大小不等");

        this.parentMap = new HashMap<>(map.size());
        // 最大深度值
        int maxDepth = depthList.get(0).getDepth();
        for (DeptDepth depth : depthList) {
            Long id = depth.getAncestorId();

            Dept organization = map.get(id);
            if (organization == null) {
                throw new ParamException("深度 list 中的部门【" + id + "】不存在于 map 中");
            }

            DeptDTO dto = new DeptDTO(organization);
            // 如果父级组织存在于 map 中，就添加到它的子级列表里
            if (this.parentMap.containsKey(dto.getParentId())) {
                this.parentMap.get(dto.getParentId()).addChildOrganization(dto);
            }
            this.parentMap.put(id, dto);
            // 因为 depthList 是按照 depth DESC 排序的，所以最大深度的节点就是根节点，添加到列表中
            if (depth.getDepth() == maxDepth) {
                this.list.add(dto);
            }
        }
    }

    /**
     * 添加子级部门
     *
     * @param dept 子级部门
     */
    public void addChildDept(Dept dept) {
        super.notNull(this.parentMap, "父级部门 map 为 null");

        DeptDTO dto = new DeptDTO(dept);
        this.parentMap.get(dto.getParentId()).addChildOrganization(dto);
    }

    /**
     * 返回结果 列表
     *
     * @return List<DeptDTO>
     */
    public List<DeptDTO> getList() {
        this.list.sort(Comparator.comparing(DeptDTO::getCreatedAt));
        return this.list;
    }

}
