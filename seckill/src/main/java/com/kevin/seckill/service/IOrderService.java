package com.kevin.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.seckill.pojo.Order;
import com.kevin.seckill.pojo.User;
import com.kevin.seckill.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2021-08-12
 */
public interface IOrderService extends IService<Order> {

    //秒杀
    Order secKill(User user, GoodsVo goods);

}
