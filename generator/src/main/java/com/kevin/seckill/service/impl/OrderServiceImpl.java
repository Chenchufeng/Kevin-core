package com.kevin.seckill.service.impl;

import com.kevin.seckill.pojo.Order;
import com.kevin.seckill.mapper.OrderMapper;
import com.kevin.seckill.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
