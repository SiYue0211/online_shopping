package com.mall.product.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AttrVo {
    /**
     * attribute id
     */
    private Long attrId;
    /**
     * attribute name
     */
    private String attrName;
    /**
     * Retrieve Or not 0:Not retrieve 1:Retrieve
     */
    private Integer searchType;
    /**
     *
     */
    private String icon;
    /**
     * available value list
     */
    private String valueSelect;
    /**
     * 0: sale, 1: base, 2: sale and base
     */
    private Integer attrType;
    /**
     * 0: forbidden
     */
    private Long enable;
    /**
     *
     */
    private Long catalogId;
    /**
     * Show description or not 0: Dont show, 1: Show
     */
    private Integer showDesc;

    private Long attrGroupId;
}
