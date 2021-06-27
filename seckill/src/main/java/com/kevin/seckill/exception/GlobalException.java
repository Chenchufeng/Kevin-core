package com.kevin.seckill.exception;

import com.kevin.seckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chufeng Chen
 * @Description:全局异常
 * @Date:Create：in 2021/6/27 20:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private RespBeanEnum respBeanEnum;
}
