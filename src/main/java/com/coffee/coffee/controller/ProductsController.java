package com.coffee.coffee.controller;

import com.coffee.coffee.entity.Products;
import com.coffee.coffee.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/product/write")
    public String productWriteForm(){

        return "productwrite";
    }


    @PostMapping("/product/writepro")
    public String productPro(Products product){

        productsService.createProduct(product);

        return "productwrite";
    }

    @GetMapping("/product/list")
    public String productList(Model model){
        model.addAttribute("list", productsService.productList());

        return "productslist";
    }

    @GetMapping("/products/modify/{id}")
    public String productsModify(@PathVariable("id") UUID id, Model model){

        model.addAttribute("product", productsService.productsView(id));
        return "productsmodify";
    }

    @PostMapping("/products/update/{id}")
    public String productUpdate(@PathVariable("id") UUID id, Products product){

        Products productTemp =  productsService.productsView(id);
        productTemp.setProduct_id(id);
        productTemp.setProduct_name(product.getProduct_name());
        productTemp.setDescription(product.getDescription());
        productTemp.setPrice(product.getPrice());
        productTemp.setCategory(product.getCategory());
        productTemp.setUpdated_at(LocalDateTime.now());

        productsService.updateProduct(productTemp);

        return "redirect:/product/list";
    }



    // uuid 사용해서 만들기....
//    @GetMapping("/product/{id}")
//    public ResponseEntity<Products> getProductById(@PathVariable("id") UUID productId){
//        Optional<Products> product = productsService.getProductById(productId);
//        if(product.isPresent()){
//            return ResponseEntity.ok(product.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }
}
