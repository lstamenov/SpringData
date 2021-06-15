package com.example.codefirstlab.entities.second.services.customer;

import com.example.codefirstlab.entities.second.Customer;
import com.example.codefirstlab.entities.second.Product;
import com.example.codefirstlab.entities.second.Sale;
import com.example.codefirstlab.entities.second.StoreLocation;
import com.example.codefirstlab.entities.second.repositories.CustomerRepository;
import com.example.codefirstlab.entities.second.services.product.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository repository;

    @Autowired
    ProductServiceImpl productService;

    @Override
    public void addCustomer(String name, String email, String creditCardNumber) {
        Customer customer = new Customer(name, email, creditCardNumber);
        repository.save(customer);
    }

    @Override
    public void deleteCustomerByName(String name) {
        repository.deleteCustomerByName(name);
    }

    @Override
    public void deleteCustomerByEmail(String email) {
        repository.deleteCustomerByEmail(email);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return repository.findCustomerByEmail(email);
    }

    @Override
    public Customer getCustomerByName(String name) {
        return repository.findCustomerByName(name);
    }

    @Override
    public void buyProduct(Product product, StoreLocation location, Customer customer) {
        Sale sale = new Sale(product, customer, location, LocalDate.now());
        customer.addSale(sale);
        productService.checkQuantity(product);
    }
}
