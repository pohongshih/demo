package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/create")
    public String createJWT(@RequestBody UserEntity user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",user.getId());
        claims.put("username",user.getUsername());
        claims.put("email",user.getUsername());
        String token = jwtUtil.generateToken(claims);
        return token;
    }


    @PreAuthorize("hasAnyRole('ROLE_member')")
    @GetMapping("/hello")
    public String hello(){
        return "hello security!!!";
    }

    @GetMapping("/user")
    public UserDetails getUser(){
        UserDetails user = userService.loadUserByUsername("b@gmail.com");
        return user;
    }


    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody UserEntity user){
        return authService.register(user);
    }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody UserEntity user){
        return authService.login(user.getUsername(), user.getPwd());
    }
}
