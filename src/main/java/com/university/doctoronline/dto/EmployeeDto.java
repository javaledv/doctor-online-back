package com.university.doctoronline.dto;

import com.university.doctoronline.entity.employee.Role;

import java.util.Set;

public class EmployeeDto extends BaseDto {

    private String email;
    private Set<Role> roles;
    private boolean isActive;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
