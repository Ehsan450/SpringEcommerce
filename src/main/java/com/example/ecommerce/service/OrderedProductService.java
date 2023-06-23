package com.example.ecommerce.service;

import com.example.ecommerce.entity.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderedProductService {
    List<OrderedProduct> orderedProducts();

    Optional<OrderedProduct> orderedProduct(long id);
    void delete(long id);

    OrderedProduct save(OrderedProduct orderedProduct);
}
