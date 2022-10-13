package com.example.springintegration.service;


import com.example.springintegration.domain.Food;
import com.example.springintegration.domain.OrderItem;

public interface KitchenService {
    Food cook(OrderItem orderItem) throws Exception;
}
