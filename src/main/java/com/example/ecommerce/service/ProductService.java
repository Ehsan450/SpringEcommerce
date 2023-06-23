package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> products();
    Optional<Product> product(String id);

    Product save(Product product);
    void delete(String id);
}
