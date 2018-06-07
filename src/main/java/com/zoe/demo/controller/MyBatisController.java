package com.zoe.demo.controller;

import com.zoe.demo.common.ResultData;
import com.zoe.demo.entity.Article;
import com.zoe.demo.oracle.entity.Dept;
import com.zoe.demo.oracle.entity.Emp;
import com.zoe.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 陈亚兰 on 2018/6/5.
 */
@RestController
@RequestMapping("/mybatis")
public class MyBatisController {
    @Autowired
    private ArticleService articleService;
//    @Autowired
//    private EmpService empService;

    @GetMapping("/mysql")
    public ResultData<List<Article>> getResult(){
        return ResultData.success(articleService.selectAll());
    }

//    @GetMapping("/oracleEmp")
//    public ResultData<List<Emp>> getEmpResult(){
//        return ResultData.success(empService.selectAll());
//    }
//    @GetMapping("/oracleDept")
//    public ResultData<List<Dept>> getDeptResult(){
//        return ResultData.success(empService.selectDeptAll());
//    }
//
//    @GetMapping("/oracleDept/annot")
//    public ResultData<List<Dept>> getDeptResultAnnot(){
//        return ResultData.success(empService.annotAll());
//    }

}
