package com.mall.coupon;

import com.mall.coupon.entity.CouponEntity;
import com.mall.coupon.service.CouponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponApplicationTests {

    @Autowired
    CouponService couponService;

    @Test
    public void contextLoads() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("Earn $199");
        couponService.save(couponEntity);

        System.out.println("Test successfully.");
    }

}
