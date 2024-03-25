package com.example.demo;

import lombok.Data;


@Data
public class UserEntityDTO {
    private Long id;
    private String username;
    private String line;
    private String email;
    private String role;
}
