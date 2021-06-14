package com.example.springintrolab.services;

import com.example.springintrolab.models.Department;
import com.example.springintrolab.models.Employee;
import com.example.springintrolab.repositories.EmployeesRepo;
import com.example.springintrolab.userinterfaces.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTO implements UserModel {
    @Autowired
    private EmployeesRepo repository;

    private String username;
    private Integer age;

    @Override
    public void registerUser(String firstName, String lastName, Integer age, Double salary, Department department) {
        repository.save(new Employee(firstName, lastName, age, salary, department));
    }

    @Override
    public void deleteUserByName(String name) {
        repository.delete(repository.findUserByUsername(name));
    }

    @Override
    public void changeUserAge(int age, String username) {
        Employee employee = repository.findUserByUsername(username);
        employee.setAge(age);
        repository.save(employee);
    }

    @Override
    public Employee getUserByName(String username) {
        return repository.findUserByUsername(username);
    }
}
