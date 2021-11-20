package com.shimengjie.wpm.dept.port.adapter.persistence.repository;

import com.shimengjie.wpm.common.utils.CollectionUtil;
import com.shimengjie.wpm.common.utils.StringUtil;
import com.shimengjie.wpm.dept.domain.model.dept.Dept;
import com.shimengjie.wpm.dept.domain.model.dept.DeptDepth;
import com.shimengjie.wpm.dept.domain.model.dept.DeptRepository;
import com.shimengjie.wpm.dept.port.adapter.persistence.repository.mapper.DeptDepthMapper;
import com.shimengjie.wpm.dept.port.adapter.persistence.repository.mapper.DeptMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shimengjie
 * @date 2021/11/20 20:42
 **/
@Service
public class MybatisDeptRepository implements DeptRepository {

    @Resource
    private DeptMapper deptMapper;
    @Resource
    private DeptDepthMapper deptDepthMapper;

    @Override
    public List<Dept> listByNameAndLevel(String name, Integer level) {
        Example example = new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("level", level);
        if (StringUtil.isNotBlank(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        return deptMapper.selectByExample(example);
    }

    @Override
    public List<DeptDepth> listParentDepthByDeptIds(Collection<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return new ArrayList<>(1);
        }
        Example example = new Example(DeptDepth.class);
        example.orderBy("depth").desc();
        example.createCriteria().andIn("dept_id", ids).andGreaterThan("depth", 0);
        return deptDepthMapper.selectByExample(example);
    }

    @Override
    public Map<Long, Dept> getMapByIds(Collection<Long> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return new HashMap<>(1);
        }
        Example example = new Example(Dept.class);
        List<Dept> list = deptMapper.selectByExample(example);
        return list.stream().collect(Collectors.toMap(Dept::getId, Function.identity()));
    }
}
