package com.example.ecommerce.entity;

import com.example.ecommerce.utils.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ordered_products")
public class OrderedProduct {
    @Id
    @Column(name = "id")
    private long orderedProductId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_ref", referencedColumnName = "id")
    private Product productRef;


    @NotNull
    @Column(name = "quantity",nullable = false)
    private int quantity;


    @NotNull
    @Column(name = "price_per_unit",nullable = false)
    private double pricePerUnit;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ref", referencedColumnName = "id")
    private Order orderedRef;
}

