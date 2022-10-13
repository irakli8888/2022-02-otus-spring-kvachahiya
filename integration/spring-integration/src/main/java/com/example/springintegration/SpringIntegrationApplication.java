package com.example.springintegration;

import com.example.springintegration.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIntegrationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringIntegrationApplication.class, args);
        OrderService orderService = ctx.getBean(OrderService.class);
        try {
            orderService.startOrdersLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
