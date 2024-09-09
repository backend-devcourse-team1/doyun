package com.coffee.coffee.repository;

import com.coffee.coffee.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {

}
