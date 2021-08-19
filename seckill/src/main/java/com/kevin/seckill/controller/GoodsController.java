package com.kevin.seckill.controller;


import com.kevin.seckill.pojo.User;
import com.kevin.seckill.service.IGoodsService;
import com.kevin.seckill.service.IUserService;
import com.kevin.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


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
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goodsVo);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();

        //秒杀状态
        int secKillStatus = 0;
        //秒杀倒计时
        int remainSeconds = 0;
        //秒杀结束倒计时
        int endSeconds = (int) ((endDate.getTime() - nowDate.getTime()) / 1000);
        //秒杀还未开始
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        } else if (nowDate.after(endDate)) {
            //秒杀已结束
            secKillStatus = 2;
            remainSeconds = -1;
            endSeconds = 0;
        } else {
            //秒杀进行中
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("secKillStatus", secKillStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("endSeconds", endSeconds);
        return "goodsDetail";
    }
}
