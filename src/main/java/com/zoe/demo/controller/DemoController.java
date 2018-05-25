package com.zoe.demo.controller;

import com.google.gson.reflect.TypeToken;
import com.zoe.demo.common.MyException;
import com.zoe.demo.common.ResultData;
import com.zoe.demo.entity.httpdo.HttpDO;
import com.zoe.demo.utils.HttpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

/**
 * Created by 陈亚兰 on 2018/5/23.
 * 测试http访问，利用TypeToken和Gson将取得的json对象转换成Java对象
 */
@RestController
@RequestMapping(value = "/test")
public class DemoController {
    @RequestMapping(value = "/gsonType",method = RequestMethod.GET)
    public ResultData<HttpDO> getHttpDO(){
        String getUrl="http://42.123.99.75:20001/api/changcheng/company/news?page={0}&count={1}";
        try{
            HttpDO resultData= HttpUtils.get(MessageFormat.format(getUrl, new Object[]{1,10}),new TypeToken<HttpDO>(){});
            return ResultData.success(resultData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultData.error(null);
    }


    @GetMapping("/exception.do")
    public ResultData helloException() throws Exception{
        throw new Exception("是Exception");
    }


    @GetMapping("/myException.do")
    public ResultData helloMyException(){
        throw new MyException("是MyException");
    }
}
