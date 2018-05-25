package com.zoe.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * created by 陈亚兰 on 18-4-13
 */
@SpringBootApplication
@EnableCaching
@EnableJpaAuditing //此注解必加因为用了@CreateDate
@EnableScheduling //定时任务
public class DemoStart {
    public static void main(String[] args){
        SpringApplication.run(DemoStart.class,args);
    }
}
