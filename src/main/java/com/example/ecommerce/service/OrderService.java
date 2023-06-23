package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> orders();
    Optional<Order> order(int id);
    Order save(Order order);

    void delete (int id);
}
