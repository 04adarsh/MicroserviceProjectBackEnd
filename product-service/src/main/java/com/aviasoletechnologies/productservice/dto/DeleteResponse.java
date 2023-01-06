package com.aviasoletechnologies.productservice.dto;

public class DeleteResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DeleteResponse(String message) {
        this.message = message;
    }

    public DeleteResponse() {
    }
}
