package com.example.codefirstlab.entities.second;

import com.example.codefirstlab.entities.second.repositories.ProductRepository;
import com.example.codefirstlab.entities.second.services.customer.CustomerServiceImpl;
import com.example.codefirstlab.entities.second.services.product.ProductServiceImpl;
import com.example.codefirstlab.entities.second.services.storeLocation.StoreLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Engine implements CommandLineRunner {
    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    StoreLocationServiceImpl locationService;

    @Autowired
    ProductRepository repository;

    @Override
    public void run(String... args) throws Exception {
        customerService.addCustomer("John", "john12@abv.bg", "1m23n5b6h");
        Customer john = customerService.getCustomerByName("John");
        System.out.println(repository.findAll().size());
        productService.createProduct("door", 1, BigDecimal.valueOf(2));
        System.out.println(repository.findAll().size());
        locationService.createLocation("Blagoevgrad");
        Product door = productService.getProductByName("door");
        System.out.println(repository.findAll().size());
        customerService.buyProduct(door, locationService.getLocation(3L), john);
    }
}
