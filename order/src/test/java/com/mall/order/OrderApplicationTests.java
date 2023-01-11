package com.mall.order;

import com.mall.order.entity.OrderEntity;
import com.mall.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {
    @Autowired
    OrderService orderService;

    @Test
    public void contextLoads() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderSn("IE1234");
        orderService.save(orderEntity);
    }

}
