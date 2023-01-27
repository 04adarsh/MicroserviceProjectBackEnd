package com.aviasoletechnologies.orderservice.repository;

import com.aviasoletechnologies.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findOrderByUserId(Long userId);
}
