package com.example.springintegration.service;

import com.example.springintegration.domain.Food;
import com.example.springintegration.domain.OrderItem;
import org.springframework.stereotype.Service;


@Service
public class KitchenServiceImpl implements KitchenService {

    @Override
    public Food cook(OrderItem orderItem) throws Exception {
        System.out.println("Cooking " + orderItem.getItemName());
        Thread.sleep(3000);
        System.out.println("Cooking " + orderItem.getItemName() + " done");
        return new Food(orderItem.getItemName());
    }
}
