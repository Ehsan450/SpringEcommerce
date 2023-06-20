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
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id")
    private int orderId;

    @NotNull
    @Column(name = "total_payable",nullable = false)
    private double totalPayable;


    @NotNull
    @Column(name = "order_status",nullable = false)
    private OrderStatusEnum orderStatus;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ordered_by", referencedColumnName = "username")

    private User orderedBy;


    @NotNull
    @Column(name = "ordered_on",nullable = false)
    private LocalDateTime orderedOn;
}
