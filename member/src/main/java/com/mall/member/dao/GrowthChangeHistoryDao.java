package com.mall.member.dao;

import com.mall.member.entity.GrowthChangeHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * The record of growth points
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:22:34
 */
@Mapper
public interface GrowthChangeHistoryDao extends BaseMapper<GrowthChangeHistoryEntity> {

}
