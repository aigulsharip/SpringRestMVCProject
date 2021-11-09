package com.example.practice5springrestmvc.service;

import com.example.practice5springrestmvc.entity.Product;
import com.example.practice5springrestmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DBInitProduct {

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void initProductTable() {

        Product product = new Product();
        product.setProductName("MacBook");
        product.setProductPrice(560000);
        product.setProductQuantity(10);
        productRepository.save(product);


        Product product2 = new Product();
        product2.setProductName("Apple Watch");
        product2.setProductPrice(900000);
        product2.setProductQuantity(20);
        productRepository.save(product2);
    }
}
