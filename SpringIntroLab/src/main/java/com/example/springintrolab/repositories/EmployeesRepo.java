package com.example.springintrolab.repositories;

import com.example.springintrolab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepo extends JpaRepository<Employee, Long> {
    Employee findUserByUsername(String username);
    void deleteUserByUsername(String username);
}
