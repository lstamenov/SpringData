package com.example.springintrolab.userinterfaces;

public interface UserControllerValidations {
    boolean isValidUsername(String username) throws Exception;
    boolean isValidAge(Integer age) throws Exception;
}
