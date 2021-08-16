package com.kevin.seckill.controller;


import com.kevin.seckill.pojo.User;
import com.kevin.seckill.service.IGoodsService;
import com.kevin.seckill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IGoodsService goodsService;
    /**
     * 跳转到商品列表页
     * @param session
     * @param model
     * @param ticket
     * @return
     */
    @RequestMapping("/toList")
    public String toList(Model model,User user){
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 跳转商品详情页
     * @author Kevin
     * @date 2021/8/16 5:37 下午
     * @param [GoodsId]
     * @return java.lang.String
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model,User user,@PathVariable Long goodsId){
        model.addAttribute("user",user);
        model.addAttribute("goods",goodsService.findGoodsVoByGoodsId(goodsId));
        return "goodsDetail";
    }
}
