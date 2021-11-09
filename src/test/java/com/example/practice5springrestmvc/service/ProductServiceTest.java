package com.example.practice5springrestmvc.service;

import com.example.practice5springrestmvc.entity.Product;
import com.example.practice5springrestmvc.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void testCreateProduct() {

        Product product = new Product();
        product.setProductName("Product1");
        product.setProductPrice(120000);
        product.setProductQuantity(10);
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product, productService.createProduct(product));


    }

    @Test
    void testFindProductById() {
        Long id = 1L;

        Product product = new Product();
        product.setProductName("Product1");
        product.setProductPrice(120000);
        product.setProductQuantity(10);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        assertEquals(product, productService.findProductById(id));
    }

    @Test
    void testFindProducts() {
        Product product = new Product();
        product.setProductName("Product1");
        product.setProductPrice(120000);
        product.setProductQuantity(10);


        Product product2 = new Product();
        product2.setProductName("Product2");
        product2.setProductPrice(90000);
        product2.setProductQuantity(20);

        when(productRepository.findAll()).thenReturn(Stream
                .of(product, product2).collect(Collectors.toList()));
        assertEquals(2, productService.findProducts().size());
    }


    @Test
    void testDeleteProductById() {
        Long id = 1L;
        productService.deleteProductById(id);
        verify(productRepository, times(1)).deleteById(id);
    }
}

