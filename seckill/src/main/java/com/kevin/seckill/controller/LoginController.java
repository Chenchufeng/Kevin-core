package com.kevin.seckill.controller;

import com.kevin.seckill.service.IUserService;
import com.kevin.seckill.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @Author: chufeng Chen
 * @Description:登录
 * @Date:Create：in 2021/6/27 14:06
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    IUserService userService;

    /*/**
     * @Author Chufeng
     * @Description 跳转登录页面
     * @Date 14:17 2021/6/27
     * @Param []
     * @return java.lang.String
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    /*/**
     * @Author Chufeng
     * @Description 登录功能
     * @Date 15:05 2021/6/27
     * @Param [loginVo]
     * @return java.lang.String
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        log.info("{}", loginVo);
        return userService.doLogin(loginVo,request,response);
    }

}
