package com.example.codefirstlab.entities.second.repositories;

import com.example.codefirstlab.entities.second.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName(String name);
    List<Product> findAll();
}
