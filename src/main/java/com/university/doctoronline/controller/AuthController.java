package com.university.doctoronline.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @PostMapping("/login")
    public Object login() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
