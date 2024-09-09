package com.coffee.coffee.service;

import com.coffee.coffee.entity.OrderItem;
import com.coffee.coffee.entity.Orders;
import com.coffee.coffee.entity.Products;
import com.coffee.coffee.repository.OrderItemRepository;
import com.coffee.coffee.repository.OrdersRepository;
import com.coffee.coffee.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @PostMapping
    public Orders createOrder(Orders order){
        order.setOrder_id(UUID.randomUUID());
        order.setCreated_at(LocalDateTime.now());
        order.setOrder_status("준비중");
        order.setUpdated_at(LocalDateTime.now());
        return ordersRepository.save(order);
    }
}
