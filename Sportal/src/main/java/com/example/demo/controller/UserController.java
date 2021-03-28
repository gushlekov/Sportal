package com.example.demo.controller;

import com.example.demo.dto.RegisterUserRequestDTO;
import com.example.demo.dto.RegisterUserResponseDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends AbstractController{

    @Autowired
    UserService userService;


    @PutMapping("/register")
    public RegisterUserResponseDTO register(@RequestBody RegisterUserRequestDTO userDTO) {
        return userService.addUser(userDTO);

    }
}
