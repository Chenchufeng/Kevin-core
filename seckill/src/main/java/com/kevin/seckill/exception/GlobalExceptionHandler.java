package com.kevin.seckill.exception;

import com.kevin.seckill.vo.RespBean;
import com.kevin.seckill.vo.RespBeanEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @Author: chufeng Chen
 * @Description:异常处理类
 * @Date:Create：in 2021/6/27 20:36
 */
//@RestControllerAdvice是控制器增强。我理解的意思就是给被@RestController注解的类加一个蓝buf，这样它的能力就蹭蹭蹭的上去了.........
@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RespBean ExceptionHandler(Exception e){
        if(e instanceof GlobalException){
            GlobalException ex=(GlobalException)e;
            return RespBean.error(ex.getRespBeanEnum());
        }else if(e instanceof BindException){
            BindException ex=(BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            respBean.setMessage("参数校验异常"+ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }

}
