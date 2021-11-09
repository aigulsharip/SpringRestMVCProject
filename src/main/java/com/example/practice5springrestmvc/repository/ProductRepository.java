package com.example.practice5springrestmvc.repository;

import com.example.practice5springrestmvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
