package com.example.codefirstlab.entities.second.services.product;

import com.example.codefirstlab.entities.second.Product;
import com.example.codefirstlab.entities.second.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService{
   @Autowired
    ProductRepository repository;

    @Override
    public void checkQuantity(Product product) {
        if (product.getQuantity() < 1){
            deleteProduct(product);
        }
    }

    @Override
    public void createProduct(String name, int quantity, BigDecimal price) {
        Product product = new Product(name, quantity, price);
        repository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        repository.delete(product);
    }

    @Override
    public Product getProductByName(String name) {
        return repository.findProductByName(name);
    }
}
