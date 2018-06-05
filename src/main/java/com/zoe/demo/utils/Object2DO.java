package com.zoe.demo.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zoe.demo.entity.User;

/**
 * Created by 陈亚兰 on 2018/5/28.
 * 把json格式，类型为object的数据与类数据和json一致的类型
 */
public class Object2DO {
      public static<T> T  getDO(Object o, TypeToken<User> token){
        Gson gson=new Gson();
        T t=gson.fromJson(o.toString(),token.getType());
        return t;
    }
}
