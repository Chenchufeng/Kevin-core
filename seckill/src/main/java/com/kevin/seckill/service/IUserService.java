package com.kevin.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.seckill.pojo.User;
import com.kevin.seckill.vo.LoginVo;
import com.kevin.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2021-06-27
 */
public interface IUserService extends IService<User> {
    /*/**
     * @Author Chufeng
     * @Description 登录
     * @Date 15:16 2021/6/27
     * @Param [loginVo]
     * @return java.lang.String
     */
    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
}
