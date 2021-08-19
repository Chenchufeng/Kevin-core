package com.kevin.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kevin.seckill.mapper.OrderMapper;
import com.kevin.seckill.pojo.Order;
import com.kevin.seckill.pojo.SeckillGoods;
import com.kevin.seckill.pojo.SeckillOrder;
import com.kevin.seckill.pojo.User;
import com.kevin.seckill.service.IOrderService;
import com.kevin.seckill.service.ISeckillGoodsService;
import com.kevin.seckill.service.ISeckillOrderService;
import com.kevin.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kevin
 * @since 2021-08-12
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    ISeckillGoodsService seckillGoodsService;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ISeckillOrderService seckillOrderService;
    //秒杀
    @Override
    public Order secKill(User user, GoodsVo goods) {
        //1.减库存
        SeckillGoods seckillGoods = seckillGoodsService.getOne(new QueryWrapper<SeckillGoods>().eq("goods_id", goods.getId()));
        seckillGoods.setStockCount(seckillGoods.getStockCount()-1);
        seckillGoodsService.updateById(seckillGoods);
        //生成订单
        Order order = new Order();
        order.setUserId(user.getId());
        order.setGoodsId(goods.getId());
        order.setDeliveryAddrId(0L);
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(goods.getGoodsPrice());
        order.setOrderChannel(3);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderMapper.insert(order);
        //生成秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setUserId(user.getId());
        seckillOrder.setOrderId(order.getId());
        seckillOrder.setGoodsId(goods.getId());
        seckillOrderService.save(seckillOrder);

        return order;
    }
}
