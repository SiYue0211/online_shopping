package com.mall.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * The operation history of order
 *
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 15:37:50
 */
@Data
@TableName("oms_order_operate_history")
public class OrderOperateHistoryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long orderId;
    /**
     *
     */
    private String operateMan;
    /**
     *
     */
    private Date createTime;
    /**
     * 0: pending payment 1: wait to mail 2: mailed 3: finished 4: closed 5: cancelled
     */
    private Integer orderStatus;
    /**
     *
     */
    private String note;

}
