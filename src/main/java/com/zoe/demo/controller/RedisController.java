package com.zoe.demo.controller;

import com.zoe.demo.common.ResultData;
import com.zoe.demo.config.RedisCacheConfig;
import com.zoe.demo.entity.BookEntity;
import com.zoe.demo.entity.Order;
import com.zoe.demo.entity.User;
import com.zoe.demo.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by 陈亚兰 on 2018/5/28.
 */
@RequestMapping(value = "/redis")
@RestController
public class RedisController {
//    @Autowired
//    private RedisComponent redisComponent;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private RedisCacheConfig redisCacheConfig;
    @Autowired
    private BookService bookService;


    @GetMapping("/getst")
    public ResultData getST(){
        User user=new User();
        user.setName("boz");
        user.setId(7);
        user.setNickName("家的");
        RedisTemplate<Object,Object> redisTemplate=redisCacheConfig.redisTemplate();
        redisTemplate.opsForSet().add("member","123");
        redisTemplate.opsForSet().add("zk","jk");
        redisTemplate.opsForSet().add("kd",user);
        return ResultData.success("dk");
    }

    @PostMapping
    @ApiImplicitParam(name = "book",value = "书",paramType = "body",dataType = "BookEntity")
    public ResultData getCache(@RequestBody BookEntity book){
        bookService.add(book);
        return ResultData.success("jdk");
    }

    @PutMapping
    @ApiImplicitParam(name = "book",value = "书",paramType = "body",dataType = "BookEntity")
    public ResultData putCache(@RequestBody BookEntity book){
        return  ResultData.success(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    @ApiImplicitParam(name="id",value = "个数",paramType = "path",dataType = "Long")
    public ResultData deleteCache(@PathVariable Long id){
        bookService.delete(id);
        return ResultData.success("");
    }

    @GetMapping("/getById/{id}")
    @ApiImplicitParam(name="id",value = "个数",paramType = "path",dataType = "Long")
    public ResultData getById(@PathVariable Long id){
        return ResultData.success(bookService.getById(id));
    }


    public static void main(String[] args) throws IOException {
        String t="Java\u2122";
        System.out.println(t);
        Scanner scanner=new Scanner(Paths.get("td.txt"),"UTF-8");
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
        String date=String.format("%TF",new Date());
        System.out.println(date);
        BigDecimal bigDecimal=new BigDecimal(3.2);
        BigDecimal bigDecimal1=new BigDecimal(3.4);
        System.out.println(bigDecimal.add(bigDecimal1));
        System.out.println(3.2+3.4);
        System.out.println(new Date());
        Order o=Order.getInstance();
        Order b=new Order(3,"jk");

    }

}
