package com.example.codefirstlab.entities.second.repositories;

import com.example.codefirstlab.entities.second.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByName(String name);
    Customer findCustomerByEmail(String email);
    void deleteCustomerByName(String name);
    void deleteCustomerByEmail(String email);
}
