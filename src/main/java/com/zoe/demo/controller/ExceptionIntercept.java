package com.zoe.demo.controller;

import com.zoe.demo.common.ResultData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by 陈亚兰 on 2018/3/6.
 * 拦截器错误汇总
 */
@RestController
@ApiIgnore
public class ExceptionIntercept {
    public ResultData getErrorInfo(String info){
        return ResultData.error(info);
    }
}
