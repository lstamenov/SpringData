package com.example.codefirstlab.entities.second.services.product;

import com.example.codefirstlab.entities.second.Product;

import java.math.BigDecimal;

public interface ProductService {
    void checkQuantity(Product product);
    void createProduct(String name, int quantity, BigDecimal price);
    void deleteProduct(Product product);
    Product getProductByName(String name);
}
