package com.example.springintrolab.userinterfaces;

import com.example.springintrolab.models.Department;
import com.example.springintrolab.models.Employee;

public interface UserModel {
    void registerUser(String firstName, String lastName, Integer age, Double salary, Department department) throws InterruptedException;
    void deleteUserByName(String name) throws InterruptedException;
    void changeUserAge(int age, String username) throws Exception;
    Employee getUserByName(String username) throws InterruptedException;
}
