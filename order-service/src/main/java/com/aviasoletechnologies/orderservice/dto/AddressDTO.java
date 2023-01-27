package com.aviasoletechnologies.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long addressId;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String landmark;

    private String state;

    private String zip;

    private String addressType;

    private String userId;
}