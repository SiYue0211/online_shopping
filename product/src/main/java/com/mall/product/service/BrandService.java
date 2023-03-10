package com.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * Brand
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-09 15:07:24
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updataDetail(BrandEntity brand);
}

