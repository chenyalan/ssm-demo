package com.zoe.demo.controller;

import com.google.gson.reflect.TypeToken;
import com.zoe.demo.common.HtmlException;
import com.zoe.demo.common.JsonException;
import com.zoe.demo.common.ResultData;
import com.zoe.demo.entity.httpdo.HttpDO;
import com.zoe.demo.utils.HttpUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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


    /**
     * 3种错误
     * @return
     * @throws Exception
     */

    @ApiOperation(value = "未知异常-json格式")
    @GetMapping("/exception.do")
    public ResultData helloException() throws Exception{
        throw new Exception("是Exception");
    }


    @ApiOperation(value = "映射error.html")
    @GetMapping("/htmlException.do")
    public ResultData htmlException(){
        throw new HtmlException("是HtmlException");
    }

    @ApiOperation(value = "业务异常-json格式")
    @GetMapping("/jsonException.do")
    public ResultData jsonException(){
        throw new JsonException("是JsonException");
    }

}
