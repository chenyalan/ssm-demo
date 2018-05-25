package com.zoe.demo.schedule;

import com.google.gson.reflect.TypeToken;
import com.zoe.demo.entity.SysRoleDO;
import com.zoe.demo.utils.HttpUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by 陈亚兰 on 2018/5/25.
 *
 */
@Component
public class Task {
    /**
     * 定时2分钟将没有点击邮箱注册的用户设置deleted=1（逻辑删除）避免邮箱资源浪费
     * @throws Exception
     */
    @Scheduled(cron = "0 0/2 * * * ?")
    public void deleteNoRegister() throws Exception {
          HttpUtils.get("http://localhost:8888/sys/user", new TypeToken<String>(){});
        TimeUnit.SECONDS.sleep(2);
    }

//    @Scheduled(cron="0/1 * * * * ?")
    public void task02(){
        System.out.println(Thread.currentThread().getName()+"....task02......");
    }

//    @Scheduled(cron="0/1 * * * * ?")
    public void task03(){
        System.out.println(Thread.currentThread().getName()+".....task03.....");
    }
}
