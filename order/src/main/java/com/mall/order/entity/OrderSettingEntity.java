package com.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:50
 */
@Data
@TableName("oms_order_setting")
public class OrderSettingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Integer flashOrderOvertime;
    /**
     *
     */
    private Integer normalOrderOvertime;
    /**
     *
     */
    private Integer confirmOvertime;
    /**
     * Return with in specified days
     */
    private Integer finishOvertime;
    /**
     *
     */
    private Integer commentOvertime;
    /**
     *
     */
    private Integer memberLevel;

}
