package com.zoe.demo.oracle.mapper;

import com.zoe.demo.oracle.entity.Emp;

import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Short empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Short empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> selectAllData();
}