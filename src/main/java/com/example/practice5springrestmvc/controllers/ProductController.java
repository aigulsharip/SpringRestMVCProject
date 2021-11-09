package com.example.practice5springrestmvc.controllers;

import com.example.practice5springrestmvc.aop.RestLog;
import com.example.practice5springrestmvc.entity.Product;
import com.example.practice5springrestmvc.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    Logger log = LoggerFactory.getLogger(ProductController.class);


    @RestLog(uri = "http://localhost:8080/products")
    @GetMapping()
    public List<Product> getProducts(HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());
        return productService.findProducts();
    }

    @RestLog (uri = "http://localhost:8080/products/{id}")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id, HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());

        return productService.findProductById(id);
    }

    @RestLog (uri = "http://localhost:8080/products")
    @PostMapping
    public Product createProduct(@RequestBody Product product, HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());

        return productService.createProduct(product);
    }


    @RestLog (uri = "http://localhost:8080/products/{id}")
    @PutMapping(value="/{id}")
    public void updateProduct(@RequestBody Product product,
                       @PathVariable Long id, HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());

        productService.createProduct(product);

    }

    @RestLog (uri = "http://localhost:8080/products/{id}")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id, HttpServletRequest request) {
        log.info("IP address of request:  {}", request.getRemoteAddr());
        return productService.deleteProductById(id);
    }















}
