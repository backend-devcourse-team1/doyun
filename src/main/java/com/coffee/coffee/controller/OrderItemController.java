package com.coffee.coffee.controller;

import com.coffee.coffee.entity.OrderItem;
import com.coffee.coffee.entity.Products;
import com.coffee.coffee.repository.OrderItemRepository;
import com.coffee.coffee.repository.ProductsRepository;
import com.coffee.coffee.service.OrderItemService;
import com.coffee.coffee.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderItemController {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/start")
    public String createOrder(OrderItem orderItem, @RequestParam("total") long total,
                              @RequestParam("quantities") int quantities){

        orderItem.setPrice(total);
        orderItem.setOrder_id(UUID.randomUUID());
        orderItem.setProduct_id(UUID.randomUUID());
        orderItem.setQuantity(quantities);
        orderItem.setCategory("커피");
        orderItem.setCreated_at(LocalDateTime.now());
        orderItemService.orderItemCreate(orderItem);

        System.out.println("저장 성공");
        System.out.println(orderItem.getCreated_at());

        return "productslist";
    }

    private Products getProduct_id(UUID productID){
        return productsRepository.findById(productID).get();
    }
}
