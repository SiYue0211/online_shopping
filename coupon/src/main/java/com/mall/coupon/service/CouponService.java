package com.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.coupon.entity.CouponEntity;

import java.util.Map;

/**
 * Coupon information
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
public interface CouponService extends IService<CouponEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

