package com.mall.order.dao;

import com.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Order
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:50
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

}
