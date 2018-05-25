package com.zoe.demo.common;

/**
 * Created by 陈亚兰 on 2017/11/1.
 * 用来捕获业务异常，返回json
 */
public class JsonException extends RuntimeException {
    public JsonException(String message){
        super(message);
    }
}
