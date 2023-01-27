package com.aviasoletechnologies.orderservice.model;



import com.aviasoletechnologies.orderservice.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @Column(name = "user_id",unique =false,nullable = false)
    private Long userId;

    private Date createdDate;

    private double totalPrice;

    private String orderStatus;

    private String paymentStatus;




//    @Column(name = "shipping_address_id",nullable = false,unique = true)
//   private Long shippingAddressId;
//
//
//    @Column(name = "billing_address_id",nullable = false,unique = true)
//    private Long billingAddressId;
//


}
