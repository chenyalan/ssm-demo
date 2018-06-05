package com.zoe.demo.oracle.mapper;

import com.zoe.demo.oracle.entity.Dept;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Short deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Short deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> selectAllData();

    @Select("select deptno,dname,loc from emp")
    @Results(value = {
         @Result(column = "deptno",property = "deptno"),
            @Result(column = "dname",property = "dname"),
            @Result(column = "loc",property = "loc"),
    })
    List<Dept> selectAnnot();
}