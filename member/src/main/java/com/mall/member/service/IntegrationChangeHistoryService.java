package com.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mall.common.utils.PageUtils;
import com.mall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * The record of points
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:22:34
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

