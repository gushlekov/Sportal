package com.example.demo.service;

import com.example.demo.dto.RegisterUserRequestDTO;
import com.example.demo.dto.RegisterUserResponseDTO;
import com.example.demo.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public RegisterUserResponseDTO addUser(RegisterUserRequestDTO userDTO) {

        //TODO

        return null;

    }
}
