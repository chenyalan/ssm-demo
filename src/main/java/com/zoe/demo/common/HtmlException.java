package com.zoe.demo.common;

/**
 * Created by 陈亚兰 on 2018/5/25.
 * 错误 返回error.html页面
 */
public class HtmlException extends RuntimeException {
    public HtmlException(String message){
        super(message);
    }
}
