package com.aviasoletechnologies.authenticationservice.dto;

import com.aviasoletechnologies.authenticationservice.model.Role;
import com.sun.istack.NotNull;

import java.util.List;
import java.util.Set;

public class UserResponseDto {

    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String email;

    private Set<String> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public UserResponseDto(Long id, String username, String email, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public UserResponseDto() {
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
