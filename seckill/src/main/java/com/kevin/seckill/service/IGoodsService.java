package com.kevin.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kevin.seckill.pojo.Goods;
import com.kevin.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kevin
 * @since 2021-08-12
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * @author Kevin
     * @date 2021/8/15 2:47 下午
     * @param []
     * @return java.util.List<com.kevin.seckill.vo.GoodsVo>
     */
    List<GoodsVo> findGoodsVo();

    /**
     * 获取商品详情
     * @author Kevin
     * @date 2021/8/16 5:42 下午
     * @param []
     * @return java.lang.String
     */
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
