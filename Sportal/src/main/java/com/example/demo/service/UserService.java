package com.example.demo.service;

import com.example.demo.dto.LoginUserDTO;
import com.example.demo.dto.RegisterUserRequestDTO;
import com.example.demo.dto.RegisterUserResponseDTO;
import com.example.demo.exeptions.AuthenticationException;
import com.example.demo.exeptions.BadRequestException;
import com.example.demo.model.User;
import com.example.demo.model.repository.UserRepository;
import com.example.demo.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public RegisterUserResponseDTO addUser(RegisterUserRequestDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new BadRequestException("Email already exist");
        } else {
            if (!Validator.validEMail(userDTO.getEmail())) {
                throw new BadRequestException("Invalid email");
            }
        }
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new BadRequestException("Username already exist");
        } else {
            if (!Validator.validUsername(userDTO.getUsername())) {
                throw new BadRequestException("Username must be at least 6 characters, without spaces");
            }
        }
        if (!Validator.validPassword(userDTO.getPassword())) {
            throw new BadRequestException("Password must be at least 5 characters, without spaces");
        }
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        User user = new User(userDTO);
        user.setCreatedAt(LocalDate.now());
        user.setLastLogin(LocalDateTime.now());
        user.setIsAdmin(false);
        user = userRepository.save(user);
        return new RegisterUserResponseDTO(user);
    }


}
