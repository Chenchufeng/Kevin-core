package com.kevin.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: chufeng Chen
 * @Description:公共返回对象
 * @Date:Create：in 2021/6/27 14:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object object;


    /*/**
     * @Author Chufeng
     * @Description 成功的返回结果
     * @Date 14:35 2021/6/27
     * @Param []
     * @return com.kevin.seckill.vo.RespBean
     */
    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),null);
    }

    /*/**
     * @Author Chufeng
     * @Description 成功的返回结果
     * @Date 14:42 2021/6/27
     * @Param [object]
     * @return com.kevin.seckill.vo.RespBean
     */
    public static RespBean success(Object object){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBeanEnum.SUCCESS.getMessage(),object);
    }

    /*/**
     * @Author Chufeng
     * @Description 失败返回结果
     * @Date 14:41 2021/6/27
     * @Param [respBeanEnum]
     * @return com.kevin.seckill.vo.RespBean
     */
    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), null);
    }

    /*/**
     * @Author Chufeng
     * @Description 失败返回结果
     * @Date 14:42 2021/6/27
     * @Param [respBeanEnum, object]
     * @return com.kevin.seckill.vo.RespBean
     */
    public static RespBean error(RespBeanEnum respBeanEnum,Object object){
        return new RespBean(respBeanEnum.getCode(), respBeanEnum.getMessage(), object);
    }

}
