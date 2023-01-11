package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.order.entity.PaymentInfoEntity;

import java.util.Map;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:49
 */
public interface PaymentInfoService extends IService<PaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

