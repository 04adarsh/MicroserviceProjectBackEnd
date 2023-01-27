package com.aviasoletechnologies.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private Long id;
    private String username;
   private List<AddressDTO> address;



}