package com.mall.member.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author Yue
 * @email siyue0112@gmail.com
 * @date 2023-01-11 16:22:34
 */
@Data
@TableName("ums_member_statistics_info")
public class MemberStatisticsInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     *
     */
    private Long memberId;
    /**
     * Current spend
     */
    private BigDecimal consumeAmount;
    /**
     * Current coupon spend
     */
    private BigDecimal couponAmount;
    /**
     *
     */
    private Integer orderCount;
    /**
     *
     */
    private Integer couponCount;
    /**
     *
     */
    private Integer commentCount;
    /**
     *
     */
    private Integer returnOrderCount;
    /**
     *
     */
    private Integer loginCount;
    /**
     * Follow number
     */
    private Integer attendCount;
    /**
     * Fans number
     */
    private Integer fansCount;
    /**
     *
     */
    private Integer collectProductCount;
    /**
     *
     */
    private Integer collectSubjectCount;
    /**
     *
     */
    private Integer collectCommentCount;
    /**
     *
     */
    private Integer inviteFriendCount;

}
