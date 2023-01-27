package com.aviasoletechnologies.authenticationservice.dto;

import com.aviasoletechnologies.authenticationservice.model.Address;

import java.util.List;

public class UserDTO {

    private Long id;
    private String username;

    private List<AddressDTO> addressList;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, List<AddressDTO> addressList) {
        this.id = id;
        this.username = username;
        this.addressList = addressList;
    }

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

    public List<AddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDTO> addressList) {
        this.addressList = addressList;
    }
}
