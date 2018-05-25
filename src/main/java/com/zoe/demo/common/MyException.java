package com.zoe.demo.common;

/**
 * Created by 陈亚兰 on 2017/11/1.
 * 用来捕获异常，返回json
 */
public class MyException extends RuntimeException {
    public MyException(String message){
        super(message);
    }
}
