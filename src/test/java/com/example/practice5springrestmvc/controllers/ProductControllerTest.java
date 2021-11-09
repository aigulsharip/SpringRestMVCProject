package com.example.practice5springrestmvc.controllers;

import com.example.practice5springrestmvc.entity.Product;
import com.example.practice5springrestmvc.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.hasSize;


import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;


    @Test
    public void testFindProductById() throws Exception {

        Product product = new Product();
        product.setProductName("MacBook");
        product.setProductPrice(560000);
        product.setProductQuantity(10);


        when(productService.findProductById(anyLong())).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("MacBook"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(560000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productQuantity").value(10))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateProduct() throws Exception {

        Product product = new Product();
        product.setId(1L);
        product.setProductName("MacBook");
        product.setProductPrice(560000);
        product.setProductQuantity(10);


        when(productService.createProduct(any(Product.class))).thenReturn(product);

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .content(new ObjectMapper().writeValueAsString(product))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("MacBook"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(560000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productQuantity").value(10));

    }


    @Test
    public void testDeleteProduct() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.delete("/products/{id}", 1) )
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    @Test
    public void testUpdateProduct() throws Exception {

        mockMvc.perform( MockMvcRequestBuilders
                        .put("/products/{id}", 2L)
                        .content(asJsonString(new Product(2L, "Apple", 100000, 17)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("Apple"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(100000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productQuantity").value(17));


        /*
        Product product = new Product();
        product.setId(1L);
        product.setProductName("MacBook");
        product.setProductPrice(560000);
        product.setProductQuantity(10);
        mockMvc.perform( MockMvcRequestBuilders
                        .put("/products/{id}", 2)
                        .content(asJsonString(product))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.productName").value("MacBook"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productPrice").value(560000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productQuantity").value(10));


    }

     */

        /*
    @Test
    public void testGetProducts() throws Exception {

        Product product = new Product();
        product.setProductName("MacBook");
        product.setProductPrice(560000);
        product.setProductQuantity(10);

        Product product2 = new Product();
        product2.setProductName("AppleWatch");
        product2.setProductPrice(78600);
        product2.setProductQuantity(6);

        mockMvc.perform( MockMvcRequestBuilders
                        .get("/products")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.products[*].productId").isNotEmpty());

    }

     */
}
