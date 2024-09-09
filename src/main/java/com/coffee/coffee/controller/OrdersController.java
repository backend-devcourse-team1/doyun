package com.coffee.coffee.controller;

import com.coffee.coffee.entity.Orders;
import com.coffee.coffee.entity.Products;
import com.coffee.coffee.repository.OrdersRepository;
import com.coffee.coffee.service.OrderService;
import com.coffee.coffee.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductsService productsService;


    @GetMapping("/buy")
    public String createForm(Model model){
        model.addAttribute("list", productsService.productList());
        return "createorder";
    }

    @PostMapping("/orders/create")
    public String createOrder(Orders orders, Model model) {
        orderService.createOrder(orders);
        System.out.println("db주입 성공");
        return "createorder";
    }

}
