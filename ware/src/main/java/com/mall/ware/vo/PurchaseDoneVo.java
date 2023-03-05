package com.mall.ware.vo;

import lombok.Data;

import java.util.List;

import javax.validation.constraints.NotNull;

@Data
public class PurchaseDoneVo {
    @NotNull
    private Long id;

    private List<PurchaseItemDoneVo> items;
}
