package com.zoe.demo.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 陈亚兰 on 2018/3/6.
 * 拦截器错误汇总
 */
@RestController
public class ExceptionIntercept {
    @GetMapping("/loginFail")
    public ResultData getErrorInfo(String info){
        return ResultData.error(info);
    }
}
