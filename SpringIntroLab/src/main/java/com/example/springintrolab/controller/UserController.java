package com.example.springintrolab.controller;

import com.example.springintrolab.models.Department;
import com.example.springintrolab.models.Employee;
import com.example.springintrolab.services.EmployeeDTO;
import com.example.springintrolab.userinterfaces.UserControllerValidations;
import com.example.springintrolab.userinterfaces.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController implements UserModel, UserControllerValidations {
    @Autowired
    EmployeeDTO employeeDTO;

    @Override
    public void registerUser(String firstName, String lastName, Integer age, Double salary, Department department) throws InterruptedException {
        execute();
        try {
            isValidUsername(firstName);
            isValidUsername(lastName);
            employeeDTO.registerUser(firstName, lastName, age, salary, department);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void deleteUserByName(String name) throws InterruptedException {
        execute();
        employeeDTO.deleteUserByName(name);
    }

    @Override
    public void changeUserAge(int age, String username) throws Exception {
        execute();
        try {
            isValidAge(age);
            employeeDTO.changeUserAge(age, username);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Employee getUserByName(String username) throws InterruptedException {
        execute();
        return employeeDTO.getUserByName(username);
    }

    @Override
    public boolean isValidUsername(String username) throws Exception {
        if (username.length() > 6){
            return true;
        }else {
            throw new Exception("Invalid username");
        }
    }

    @Override
    public boolean isValidAge(Integer age) throws Exception {
        if (age > 18 && age < 100){
            return true;
        }else {
            throw new Exception("Invalid age");
        }
    }

    private void execute() throws InterruptedException {
        System.out.println("Executing command...");
        Thread.sleep(1000);
        System.out.println("Command successfully executed!");
    }
}
