package com.kevin.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: chufeng Chen
 * @Description:
 * @Date:Create：in 2021/6/26 21:05
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    /*
     * @Author Chufeng
     * @Description 测试页面跳转
     * @Date 21:13 2021/6/26
     * @Param [model]
     * @return java.lang.String
     */
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","XXXX");
        return "hello";
    }
}
