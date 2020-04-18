package com.university.doctoronline.service.impl;

import com.university.doctoronline.service.EmployeeService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeService employeeService;

    public UserDetailsServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return employeeService.getByEmail(email)
                .map(employee -> new User(employee.getEmail(), employee.getPassword(),
                        employee.getRoles().stream()
                                .map(role -> new SimpleGrantedAuthority(role.getName()))
                                .collect(Collectors.toList()))).orElseThrow(() -> new RuntimeException("User with email:" + email + " is not exist!!!!"));
    }
}
