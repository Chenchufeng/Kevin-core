package com.kevin.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/27 14:19
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"服务端异常"),

    //登录模块5002xx
    LOGIN_ERROR(500210,"用户名或密码不正确"),
    MOBILE_ERROR(500211,"手机号码格式不正确"),
    BIND_ERROR(500212,"参数校验异常"),

    //秒杀模块5005xx
    EMPTY_STOCK(500500, "库存不足"),
    REPEATE_ERROR(500501, "该商品每人限购一件"),
    VERIFYCODE_GENERATE_ERROR(500502, "验证码生成错误"),
    VERIFYCODE_ERROR(500502, "验证码错误");

    private final Integer code;
    private final String message;

}
