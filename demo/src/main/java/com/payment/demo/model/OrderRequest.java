package com.payment.demo.model;

import lombok.Data;

@Data
public class OrderRequest {
    private String customerName;
    private String email;
    private String phoneNumber;
    private String amount;
}