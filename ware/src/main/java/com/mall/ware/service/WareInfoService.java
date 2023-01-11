package com.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.ware.entity.WareInfoEntity;

import java.util.Map;

/**
 * warehouse information
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:34:52
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

