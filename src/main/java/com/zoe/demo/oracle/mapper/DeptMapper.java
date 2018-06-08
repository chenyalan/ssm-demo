package com.zoe.demo.oracle.mapper;

import com.zoe.demo.oracle.entity.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Short deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Short deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}