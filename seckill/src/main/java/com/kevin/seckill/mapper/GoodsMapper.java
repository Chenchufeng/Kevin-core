package com.kevin.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kevin.seckill.pojo.Goods;
import com.kevin.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Kevin
 * @since 2021-08-12
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    //获取商品列表
    List<GoodsVo> findGoodsVo();

    //获取商品详情
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
