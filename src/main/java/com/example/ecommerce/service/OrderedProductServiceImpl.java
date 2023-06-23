package com.example.ecommerce.service;

import com.example.ecommerce.entity.OrderedProduct;
import com.example.ecommerce.repository.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderedProductServiceImpl implements OrderedProductService {
    private final OrderedProductRepository orderedProductRepository;

    @Autowired
    public OrderedProductServiceImpl(OrderedProductRepository orderedProductRepository) {

        this.orderedProductRepository = orderedProductRepository;
    }

    @Override
    public List<OrderedProduct> orderedProducts() {
        return orderedProductRepository.findAll();
    }

    @Override
    public Optional<OrderedProduct> orderedProduct(long id) {
        return orderedProductRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        orderedProductRepository.deleteById(id);
    }

    @Override
    public OrderedProduct save(OrderedProduct orderedProduct) {
        return orderedProductRepository.saveAndFlush(orderedProduct);
    }
}
