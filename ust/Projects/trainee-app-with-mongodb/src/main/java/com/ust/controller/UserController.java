package com.ust.controller;

import com.ust.model.UserModel;
import com.ust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserModel userModel) {

//        System.out.println("inside the save user function");
//        System.out.println(userModel.getUserName());
//        System.out.println(userModel.getPassword());
//        System.out.println(userModel.getRole());
        String encryptedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encryptedPassword);
        return userRepository.save(userModel);
    }
}
