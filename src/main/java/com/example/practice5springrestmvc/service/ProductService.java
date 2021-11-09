package com.example.practice5springrestmvc.service;

import com.example.practice5springrestmvc.entity.Product;
import com.example.practice5springrestmvc.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public Product findProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public String deleteProductById(Long id) {
        productRepository.deleteById(id);
        return "Product got deleted";
    }
}

