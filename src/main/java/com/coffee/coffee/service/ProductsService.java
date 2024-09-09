package com.coffee.coffee.service;

import com.coffee.coffee.entity.Products;
import com.coffee.coffee.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    // 상품 작성
    public Products createProduct(Products product){
        product.setProduct_id(UUID.randomUUID());
        product.setCreated_at(LocalDateTime.now());
        return productsRepository.save(product);
    }

    public Products updateProduct(Products product){
        product.setUpdated_at(LocalDateTime.now());
        return productsRepository.save(product);
    }


    // 상품 리스트 처리
    public List<Products> productList(){

        return productsRepository.findAll();
    }

     //특정 상품 불러오기
    public Optional<Products> getProductById(UUID id){
        return productsRepository.findById(id);
    }

    public Products productsView(UUID uuid){
        return productsRepository.findById(uuid).get();
    }


}
