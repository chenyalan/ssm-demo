package com.zoe.demo.oracle.service.impl;

import com.zoe.demo.oracle.entity.Dept;
import com.zoe.demo.oracle.entity.Emp;
import com.zoe.demo.oracle.mapper.DeptMapper;
import com.zoe.demo.oracle.mapper.EmpMapper;
import com.zoe.demo.oracle.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 陈亚兰 on 2018/6/5.
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public List<Dept> selectDeptAll() {
        return deptMapper.selectAll();
    }

    @Override
    public List<Dept> annotAll() {
        return deptMapper.annotAll();
    }
}
