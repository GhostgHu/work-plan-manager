package com.shimengjie.wpm.dept.domain.model.dept;

import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author shimengjie
 * @date 2021/11/20 20:23
 **/
public interface DeptRepository {

    /**
     * 根据 部门名称和级别 查询部门列表
     *
     * @param name  部门名称，如果为空，就查询全部
     * @param level 级别
     * @return List <Dept>
     */
    List<Dept> listByNameAndLevel(@Param("name") String name, @Param("level") Integer level);


    /**
     * 根据 部门ID集合 查询它的父级节点深度数据列表，按照 depth 字段 ASC 排序
     * 注意：id 集合不能为空
     *
     * @param ids 部门ID集合
     * @return List<DeptDepth>
     */
    List<DeptDepth> listParentDepthByDeptIds(Collection<Long> ids);

    /**
     * 根据 id 集合查询数据，并返回 map
     * 注意：id 集合不能为空
     *
     * @param ids ID 集合
     * @return Map <id, Dept>
     */
    Map<Long, Dept> getMapByIds(Collection<Long> ids);
}
