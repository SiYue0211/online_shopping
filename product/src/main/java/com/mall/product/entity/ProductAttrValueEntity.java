package com.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Item attribute
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-09 15:07:24
 */
@Data
@TableName("pms_product_attr_value")
public class ProductAttrValueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * item id
     */
    private Long spuId;
    /**
     * attribute id
     */
    private Long attrId;
    /**
     * attribute name
     */
    private String attrName;
    /**
     * attribute value
     */
    private String attrValue;
    /**
     * sort
     */
    private Integer attrSort;
    /**
     * 0: NO 1: Yes
     */
    private Integer quickShow;

}
