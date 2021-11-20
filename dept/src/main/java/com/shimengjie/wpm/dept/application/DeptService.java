package com.shimengjie.wpm.dept.application;

import com.shimengjie.wpm.common.utils.CollectionUtil;
import com.shimengjie.wpm.dept.constant.DeptConstant;
import com.shimengjie.wpm.dept.domain.model.dept.*;
import com.shimengjie.wpm.dept.port.adapter.persistence.repository.MybatisDeptRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author shimengjie
 * @date 2021/11/20 20:21
 **/
@Service
public class DeptService {

    @Resource
    private MybatisDeptRepository mybatisDeptRepository;

    /**
     * 根据部门名称查询部门及其父级部门列表
     * @param name 名称
     * @return List<DeptDTO>
     */
    public List<DeptDTO> listDept(String name) {
        // 查询三级部门
        List<Dept> organizations = mybatisDeptRepository.listByNameAndLevel(name, DeptConstant.Level.THIRD);
        if (CollectionUtil.isEmpty(organizations)) {
            return new ArrayList<>(1);
        }
        // 所有祖先节点记录
        Set<Long> organizationIds = organizations.stream().map(Dept::getId).collect(Collectors.toSet());
        List<DeptDepth> depthList = mybatisDeptRepository.listParentDepthByDeptIds(organizationIds);
        // 查询所有祖先节点的数据
        Set<Long> ids = depthList.stream().map(DeptDepth::getAncestorId).collect(Collectors.toSet());
        Map<Long, Dept> parentMap = mybatisDeptRepository.getMapByIds(ids);
        if (CollectionUtil.isMapEmpty(parentMap)) {
            return new ArrayList<>(1);
        }
        // 封装结果
        DeptTreeVO vo = new DeptTreeVO(parentMap, depthList);
        for (Dept dto : organizations) {
            vo.addChildDept(dto);
        }
        return vo.getList();
    }
}
