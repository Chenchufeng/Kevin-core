package com.kevin.seckill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kevin.seckill.pojo.Order;
import com.kevin.seckill.pojo.SeckillOrder;
import com.kevin.seckill.pojo.User;
import com.kevin.seckill.service.IGoodsService;
import com.kevin.seckill.service.IOrderService;
import com.kevin.seckill.service.ISeckillOrderService;
import com.kevin.seckill.vo.GoodsVo;
import com.kevin.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Kevin
 * @Date: 2021/8/19 16:18
 * @Description:
 */
@Controller
@RequestMapping("/seckill")
public class SecKillController {
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/doSeckill")
    public String doSecKill(Model model, User user,Long goodsId){
        if (user==null){
            return "login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if(goods.getGoodsStock()<1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secKillFail";
        }
        //判断是否重复抢购
        SeckillOrder seckillOrder = seckillOrderService.getOne(new QueryWrapper<SeckillOrder>().eq("userId", user.getId()).eq("goodsId", goodsId));
        if(seckillOrder!=null){
            model.addAttribute("errmsg",RespBeanEnum.REPEATE_ERROR.getMessage());
            return "secKillFail";
        }
        //生成订单
        Order order = orderService.secKill(user, goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        return "orderDetail";
    }
}