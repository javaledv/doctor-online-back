package com.university.doctoronline.controller;

import com.university.doctoronline.dto.EmployeeDto;
import com.university.doctoronline.dto.converter.EmployeeDtoConverter;
import com.university.doctoronline.exception.UserNotFoundException;
import com.university.doctoronline.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    private final EmployeeService employeeService;
    private final EmployeeDtoConverter employeeDtoConverter;

    public AuthController(EmployeeService employeeService, EmployeeDtoConverter employeeDtoConverter) {
        this.employeeService = employeeService;
        this.employeeDtoConverter = employeeDtoConverter;
    }

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @PostMapping("/login")
    public EmployeeDto login() {
        final var principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return employeeDtoConverter.toDto(employeeService.getByEmail(principal.getUsername())
                .orElseThrow(UserNotFoundException::new));
    }
}
