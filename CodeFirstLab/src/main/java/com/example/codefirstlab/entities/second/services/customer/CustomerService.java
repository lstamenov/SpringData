package com.example.codefirstlab.entities.second.services.customer;


import com.example.codefirstlab.entities.second.Customer;
import com.example.codefirstlab.entities.second.Product;
import com.example.codefirstlab.entities.second.StoreLocation;

public interface CustomerService {
    void addCustomer(String name, String email, String creditCardNumber);
    void deleteCustomerByName(String name);
    void deleteCustomerByEmail(String email);
    Customer getCustomerByEmail(String email);
    Customer getCustomerByName(String name);
    void buyProduct(Product product, StoreLocation location, Customer customer);
}
