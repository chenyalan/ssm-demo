package com.zoe.demo.config;

import com.zoe.demo.common.HtmlException;
import com.zoe.demo.common.JsonException;
import com.zoe.demo.common.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 陈亚兰 on 2018/5/25.
 * 统一异常处理-返回error页面和json两种
 *方法上注解--- @ExceptionHandler里面的value决定了走type1页面还是type2-json格式
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * type1 映射页面，templates下面放error.html
     *  捕获 HtmlException
     */
    public static final String DEFAULT_ERROR_VIEW="error";

    public static final String ERROR_MESSAGE="failure";

    @ExceptionHandler(value = HtmlException.class)
    public ModelAndView modelAndView(HttpServletRequest request,HtmlException e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * type2 返回json格式
     * 捕获 new  JsonException("...")
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ResultData<String> jsonErrorHandler(HttpServletRequest request, JsonException e){
        ResultData<String> resultData=new ResultData<>();
        resultData.setMessage(ERROR_MESSAGE);
        resultData.setCode(400);
        resultData.setResult("业务异常-"+e.getMessage());
        resultData.setUrl(request.getRequestURL().toString());
        return resultData;
    }


    //json格式-因为加了ResponseBody
    //捕获Exception未知错误
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData<String> BasicExceptionHandler(HttpServletRequest request, Exception e){
        ResultData<String> resultData=new ResultData<>();
        resultData.setMessage(ERROR_MESSAGE);
        resultData.setCode(400);
        resultData.setResult("未知异常-"+e.getMessage());
        resultData.setUrl(request.getRequestURL().toString());
        return resultData;
    }

    /**
     * 参数绑定时候，不需要再手动必须写BindingResult了
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultData<String> illegalParamsExceptionHandler(MethodArgumentNotValidException e,HttpServletRequest request) {
        ResultData<String> resultData=new ResultData<>();
        resultData.setMessage(ERROR_MESSAGE);
        resultData.setCode(87);
        resultData.setResult("参数"+e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        resultData.setUrl(request.getRequestURL().toString());
        return resultData;
    }

}
