package com.zoe.demo.service.redis;


import com.zoe.demo.entity.redis.UserRedis;

/**
 * Created by 陈亚兰 on 2018/2/28.
 */
public interface UserRedisService {

    UserRedis findByAccount(String account);

    UserRedis save(UserRedis userRedis);

    void delete(String account);
}
