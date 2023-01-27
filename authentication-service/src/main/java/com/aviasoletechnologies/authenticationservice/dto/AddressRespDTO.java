package com.aviasoletechnologies.authenticationservice.dto;

public class AddressRespDTO {

    private String message;


    public AddressRespDTO() {
    }

    public AddressRespDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
