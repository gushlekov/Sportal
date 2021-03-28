package com.example.demo.model;

import com.example.demo.dto.RegisterUserRequestDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private LocalDate createdAt;
    @Column
    private LocalDateTime lastLogin;
    @Column
    private Boolean isAdmin;


    //private List<News> news;


    //private List<Comment> comments;

    public User(RegisterUserRequestDTO userRequestDTO){
        id = userRequestDTO.getId();
        username = userRequestDTO.getUsername();
        password = userRequestDTO.getPassword();
        email = userRequestDTO.getEmail();
    }







}
