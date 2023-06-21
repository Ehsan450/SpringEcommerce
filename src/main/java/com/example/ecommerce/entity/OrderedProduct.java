package com.example.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "ordered_products")
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long orderedProductId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_ref", referencedColumnName = "id")
    private Product productRef;


    @NotNull
    @Column(name = "quantity", nullable = false)
    private Integer quantity;


    @NotNull
    @Column(name = "price_per_unit", nullable = false)
    private Double pricePerUnit;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_ref", referencedColumnName = "id")
    private Order orderedRef;
}

