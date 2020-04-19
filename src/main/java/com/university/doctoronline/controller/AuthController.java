package com.university.doctoronline.controller;

import com.university.doctoronline.dto.UserDto;
import com.university.doctoronline.exception.UserNotFoundException;
import com.university.doctoronline.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @PostMapping("/login")
    public UserDto login() {
        final var principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final var user = userService.getByEmail(principal.getUsername()).orElseThrow(UserNotFoundException::new);

        final var userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRoles(user.getRoles());
        userDto.setActive(user.isActive());

        return userDto;
    }
}
