package com.rabbitmq.springbootorderrabbitmqproducer;

import com.rabbitmq.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void testOrderFanout(){ orderService.makeOrder("1","1",12); }

    @Test
    void testOrderDirect(){
        orderService.makeOrderDirect("1","1",12);
    }

    @Test
    void testOrderTopic(){
        orderService.makeOrderTopic("1","1",12);
    }

    @Test
    void testOrderTtl(){
        orderService.makeOrderTtl("1","1",12);
    }

    @Test
    void testOrderTtlMessage(){
        orderService.makeOrderTtlMessasge("1","1",12);
    }

}
