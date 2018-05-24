package com.zoe.demo.controller;
import com.zoe.demo.common.ResultData;
import com.zoe.demo.entity.AccountContext;
import com.zoe.demo.entity.SysPermissionDO;
import com.zoe.demo.entity.SysUserDO;
import com.zoe.demo.entity.redis.UserRedis;
import com.zoe.demo.entity.vo.PermissionVO;
import com.zoe.demo.service.SysService;
import com.zoe.demo.service.redis.UserRedisService;
import com.zoe.demo.utils.CookieUtils;
import com.zoe.demo.utils.PassWordUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 陈亚兰 on 2018/2/26.
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户操作")
public class UserOperationController {
    @Value("${redis.time}")
    private int time;
    @Autowired
    private SysService sysService;

    @Autowired
    private UserRedisService userRedisService;

    @ApiOperation("登陆")
    @GetMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name="account",value = "帐户名",defaultValue = "cyl",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "password",value = "密码",defaultValue = "123456",paramType = "query",dataType = "String")
    })
    public ResultData login(String account, String password, HttpServletResponse response) throws ParseException {
        SysUserDO sysUserDO=sysService.findByAccount(account);
        if(sysUserDO==null){
            return ResultData.error("不存在本账号");
        }
        if(!PassWordUtils.equals(password,sysUserDO.getSalt(),sysUserDO.getPassword())){
            return ResultData.error("密码错误");
        }
        Set<PermissionVO> permissionDOSet=new HashSet<>();
        for(SysPermissionDO pp:sysUserDO.getRole().getPermissions()){
            PermissionVO p=new PermissionVO(pp.getPermissionEN());
            permissionDOSet.add(p);
        }
        UserRedis userRedis=new UserRedis(account,sysUserDO.getRole().getRoleName(),sysUserDO.getSex(),permissionDOSet,sysUserDO.getRole().getRoleType(),DateUtils.addSeconds(new Date(),time));
        userRedisService.save(userRedis);
        //添加cookie
        int time=30*60;//设置为30分钟
        String token= DigestUtils.md5Hex(userRedis.getAccount()+new Date());
        CookieUtils.addCookie(response,"user",userRedis.getAccount(),time);
        //设置用户上下文，借助ThreadLocal
        AccountContext.setContext(userRedis);
        return ResultData.success("登陆成功");
    }

    @ApiOperation("修改密码")
    @GetMapping("/updatePassword/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",paramType = "path",dataType = "Long"),
            @ApiImplicitParam(name = "password",value = "密码",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "rePassword",value = "重复密码",paramType = "query",dataType = "String")
    })
    public ResultData updatePassword(@PathVariable Long id,String password,String rePassword){
        if(!password.equals(rePassword)){
            return ResultData.error("两次密码不一致");
        }
        if(password.length()<6||password.length()>20){
            return ResultData.error("密码为6-20位");
        }
        SysUserDO sysUserDO=sysService.findByUserId(id);
        sysUserDO.setPassword(PassWordUtils.privatePassWord(password,sysUserDO.getSalt()));
        sysService.add(sysUserDO);
        return ResultData.success("修改成功");
    }
}
