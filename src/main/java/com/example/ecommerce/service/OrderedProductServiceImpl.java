package com.example.ecommerce.service;

import com.example.ecommerce.entity.OrderedProduct;
import com.example.ecommerce.repository.OrderedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderedProductServiceImpl implements OrderedProductService {
    private final OrderedProductRepository orderedProductRepository;

    @Autowired
    public OrderedProductServiceImpl(OrderedProductRepository orderedProductRepository) {
        this.orderedProductRepository = orderedProductRepository;
    }

    @Override
    @Transactional
    public OrderedProduct save(OrderedProduct orderedProduct) {
        return this.orderedProductRepository.saveAndFlush(orderedProduct);
    }
    //save er upor alltym put transactional;
}
