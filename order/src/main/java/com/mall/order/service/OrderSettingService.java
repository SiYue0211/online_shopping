package com.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:50
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

