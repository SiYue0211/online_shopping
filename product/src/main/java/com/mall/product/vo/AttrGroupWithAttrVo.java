package com.mall.product.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.mall.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

@Data
public class AttrGroupWithAttrVo {
    private Long attrGroupId;
    private String attrGroupName;
    private Integer sort;
    private String descript;
    private String icon;
    private Long catalogId;
    private Long[] catalogPath;
    private List<AttrEntity> attrs;
}
