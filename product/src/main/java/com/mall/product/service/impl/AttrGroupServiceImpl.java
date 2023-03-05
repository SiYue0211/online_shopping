package com.mall.product.service.impl;

import com.mall.product.entity.AttrEntity;
import com.mall.product.service.AttrService;
import com.mall.product.vo.AttrGroupWithAttrVo;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mall.common.utils.PageUtils;
import com.mall.common.utils.Query;

import com.mall.product.dao.AttrGroupDao;
import com.mall.product.entity.AttrGroupEntity;
import com.mall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {
    @Autowired
    AttrService attrService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catalogId) {
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        String key = (String) params.get("key");

        if (catalogId != 0) {
            wrapper.eq("catalog_id", catalogId);
        }

        if (!StringUtils.isNullOrEmpty(key)) {
            wrapper.and((obj)->{
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }

        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    public List<AttrGroupWithAttrVo> getAttrGroupWithAttrsByCatalogId(Long catalogId) {
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catalog_id", catalogId));
        List<AttrGroupWithAttrVo> collect = attrGroupEntities.stream().map(group -> {
            AttrGroupWithAttrVo attrVo = new AttrGroupWithAttrVo();
            BeanUtils.copyProperties(group, attrVo);
            ArrayList<AttrEntity> attrEntities = attrService.getRelationAttr(attrVo.getAttrGroupId());
            attrVo.setAttrs(attrEntities);
            return attrVo;
        }).collect(Collectors.toList());

        return collect;
    }
}