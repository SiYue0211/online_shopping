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
@TableName("sms_spu_bounds")
public class SpuBoundsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long spuId;
    /**
     * growth points
     */
    private BigDecimal growBounds;
    /**
     * shopping points
     */
    private BigDecimal buyBounds;
    /**
     * Four-digit status code, from right to left; 0: No discount, whether to give growth points; 1: No discount, whether to give shopping points;2: Discount, whether to give growth points;3: Discount, whether to give shopping points
     */
    private Integer work;

}
