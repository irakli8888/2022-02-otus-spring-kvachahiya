package com.example.springintegration.integraton;


import com.example.springintegration.domain.Food;
import com.example.springintegration.domain.OrderItem;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


import java.util.Collection;

@MessagingGateway
public interface Cafe {

    @Gateway(requestChannel = "itemsChannel", replyChannel = "foodChannel")
    Collection<Food> process(Collection<OrderItem> orderItem);
}
