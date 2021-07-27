package com.kevin.seckill.controller;


import com.kevin.seckill.pojo.User;
import com.kevin.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;
    /**
     * 跳转到商品列表页
     * @param session
     * @param model
     * @param ticket
     * @return
     */
    @RequestMapping("toList")
    public String toList(Model model,User user){
        model.addAttribute("user",user);
        return "goodsList";
    }
}
