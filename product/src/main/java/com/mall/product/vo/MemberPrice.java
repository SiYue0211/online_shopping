package com.mall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
class MemberPrice {
    private Long id;
    private String name;
    private BigDecimal price;

    // getters and setters
}