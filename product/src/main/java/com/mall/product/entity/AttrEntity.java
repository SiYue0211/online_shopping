package com.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * product attribute
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-09 15:07:24
 */
@Data
@TableName("pms_attr")
public class AttrEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * attribute id
     */
    @TableId
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
    private Long catelogId;
    /**
     * Show description or not 0: Dont show, 1: Show
     */
    private Integer showDesc;

}
