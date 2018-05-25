package com.zoe.demo.common;

import lombok.Data;

/**
 * Created by 陈亚兰 on 2018/5/25.
 */
@Data
public class ErrorInfo<T> {
    public static final Integer OK=0;
    public static final Integer ERROR=100;
    private Integer code;
    private String message;
    private String url;
    private T data;

}
