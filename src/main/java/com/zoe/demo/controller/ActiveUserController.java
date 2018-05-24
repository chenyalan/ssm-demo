package com.zoe.demo.controller;

import com.zoe.demo.entity.SysUserDO;
import com.zoe.demo.meiju.State;
import com.zoe.demo.service.SysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 陈亚兰 on 2018/2/26.
 */
@Controller
@Api(description = "激活用户")
public class ActiveUserController {
    @Autowired
    private SysService sysService;
    @ApiOperation("激活用户")
    @GetMapping("/activeUser")
    public ModelAndView activeUser(HttpServletRequest request, @ApiIgnore ModelAndView model){
        String account=request.getParameter("account");
        SysUserDO user=sysService.findByAccount(account);
        Date now=new Date();
        Date deadTime = new Date(user.getCreateDate().getTime()+ 300000);
        if(now.after(deadTime)){
            model.setViewName("activefailure");
            user.setDeleted(true);
            sysService.add(user);
        }else{
            user.setUserState(State.Using);
            sysService.add(user);
            model.setViewName("login");
        }
        return model;
    }
}
