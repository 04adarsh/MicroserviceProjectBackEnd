package com.aviasoletechnologies.orderservice.controller;


import com.aviasoletechnologies.orderservice.dto.AddressDTO;
import com.aviasoletechnologies.orderservice.exception.CustomException;
import com.aviasoletechnologies.orderservice.model.Order;
import com.aviasoletechnologies.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.aviasoletechnologies.orderservice.dto.UserDTO;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
   private RestTemplate restTemplate;

    private Long userId;

    @Autowired
   private OrderRepository orderRepository;



    @PostMapping("/create/{userId}")
    public ResponseEntity<?> getResponse(@PathVariable Long userId){
      ResponseEntity<UserDTO> user=  this.restTemplate.getForEntity("http://localhost:9090/api/v1/user/get/"+userId,UserDTO.class);
      Order order=new Order();
//      AddressDTO[] address=  this.restTemplate.getForObject("http://localhost:9090/api/v1/user/address/get/"+user.getBody().getId(),AddressDTO[].class);
        order.setUserId(user.getBody().getId());
//        List<AddressDTO> adLis=Arrays.asList(address);
//        for(AddressDTO addressDTO:adLis){
//            System.out.println(addressDTO);
//            if(addressDTO.getAddressType().equalsIgnoreCase("shipping")){
//                order.setShippingAddressId(addressDTO.getAddressId());
//            }
//            else if(addressDTO.getAddressType().equalsIgnoreCase("billing")){
//                order.setBillingAddressId(addressDTO.getAddressId());
//            }
//        }
    this.orderRepository.save(order);
        return ResponseEntity.ok("ok");


    }

    @GetMapping("/getOrder/{userId}")
    public ResponseEntity<List<Order>> getOrder(@PathVariable Long userId){
        List<Order> order=this.orderRepository.findOrderByUserId(userId);
        if(order==null){
            throw new CustomException("order not found");
        }
        return ResponseEntity.ok(order);
    }



}
