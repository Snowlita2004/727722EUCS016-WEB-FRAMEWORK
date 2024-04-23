package com.example.angel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.angel.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>{
    
}
