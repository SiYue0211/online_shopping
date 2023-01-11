package com.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:05:38
 */
@Data
@TableName("sms_sku_ladder")
public class SkuLadderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * spu_id
     */
    private Long skuId;
    /**
     * You will get discount if the count of your items is greater than full_count
     */
    private Integer fullCount;
    /**
     *
     */
    private BigDecimal discount;
    /**
     * Price after discount
     */
    private BigDecimal price;
    /**
     * 0: unsuperimposed 1: superimposed
     */
    private Integer addOther;

}
