package com.aviasoletechnologies.authenticationservice.jwtrequest;

import com.aviasoletechnologies.authenticationservice.model.Address;
import com.sun.istack.NotNull;

import java.util.Set;

public class SignupRequest {
    @NotNull
    private String username;

    @NotNull
    private String email;

    private Set<String> role;

    @NotNull
    private String password;

//    private Address address;
//
//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
