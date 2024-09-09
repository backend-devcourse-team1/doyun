package com.coffee.coffee.service;

import com.coffee.coffee.entity.OrderItem;
import com.coffee.coffee.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OrderItemService {
    Random random = new Random();

    @Autowired
    private OrderItemRepository orderItemRepository;

    @PostMapping
    public OrderItem orderItemCreate(OrderItem orderItem){
        orderItem.setSeq(random.nextInt(100000000));
        orderItem.setCreated_at(LocalDateTime.now());

        return orderItemRepository.save(orderItem);
    }

}
