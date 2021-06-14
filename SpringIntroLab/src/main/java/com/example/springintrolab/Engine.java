package com.example.springintrolab;

import com.example.springintrolab.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class Engine {

//    @Autowired
//    UserController controller;
//
//    @Override
//    public void run(String... args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String input =  reader.readLine();
//        while (!input.equals("END")) {
//            System.out.print("Enter user command or type 'END' for exit");
//            System.out.println();
//            String[] words = input.split("\\s+");
//            switch (words[0]) {
//                case "register":
//                    controller.registerUser(words[1], Integer.parseInt(words[2]));
//                    break;
//                case "delete":
//                    controller.deleteUserByName(words[1]);
//                    break;
//                case "changeAge":
//                    controller.changeUserAge(Integer.parseInt(words[1]), words[2]);
//                    break;
//                case "END":
//                    break;
//                default:
//                    System.out.println("Invalid operation");
//            }
//            input = reader.readLine();
//        }
//    }
}
