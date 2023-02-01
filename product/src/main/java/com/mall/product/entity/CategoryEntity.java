package com.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * product category
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-09 15:07:24
 */
@Data
@TableName("pms_category")
public class CategoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * category id
     */
    @TableId
    private Long catId;
    /**
     * category name
     */
    private String name;
    /**
     * parent category id
     */
    private Long parentCid;
    /**
     * category level
     */
    private Integer catLevel;
    /**
     * 0:invisible, 1:visible
     */
    @TableLogic(value = "1", delval = "0")
    private Integer showStatus;
    /**
     *
     */
    private Integer sort;
    /**
     * icon url
     */
    private String icon;
    /**
     * unit of measurement
     */
    private String productUnit;
    /**
     * quantity
     */
    private Integer productCount;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private List<CategoryEntity> children;

}
