package com.zoe.demo.config;

import com.zoe.demo.common.ErrorInfo;
import com.zoe.demo.common.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈亚兰 on 2018/5/25.
 * 统一异常处理-返回error页面和json两种
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * type1 映射页面，templates下面放error.html
     * new Exception("message...")
     */
    public static final String DEFAULT_ERROR_VIEW="error";
    @ExceptionHandler(value = Exception.class)
    public ModelAndView modelAndView(HttpServletRequest request,Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * type2 返回json格式 throw new  myException("...")
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException e){
        ErrorInfo<String> errorInfo=new ErrorInfo<>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("some data");
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;
    }
}
