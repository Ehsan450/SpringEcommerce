package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id")
    private String productId;


    @NotNull
    @Column(name = "product_name",nullable = false)
    private String productName;


    @NotNull
    @Column(name = "category",nullable = false)
    private String category;

    @NotNull
    @Column(name = "stock",nullable = false)
    private int stock;

    @NotNull
    @Column(name = "price_per_unit",nullable = false)
    private String pricePerUnit;

    @NotNull
    @Column(name = "added_on",nullable = false)
    private LocalDateTime addedOn;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "added_by", referencedColumnName = "username")
    private User addedBy;

    @NotNull
    @Column(name = "last_updated_on",nullable = false)
    private LocalDateTime lastUpdatedOn;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "last_updated_by", referencedColumnName = "username")
    private User lastUpdatedBy;





}
