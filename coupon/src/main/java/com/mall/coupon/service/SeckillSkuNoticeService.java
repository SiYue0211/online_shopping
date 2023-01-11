package com.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * subscription for seckill items
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

