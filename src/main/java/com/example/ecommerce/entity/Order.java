package com.example.ecommerce.entity;

import com.example.ecommerce.utils.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer orderId;

    @NotNull
    @Column(name = "total_payable", nullable = false)
    private Double totalPayable;

    @NotNull
    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ordered_by", referencedColumnName = "username")
    private User orderedBy;

    @NotNull
    @Column(name = "ordered_on", nullable = false)
    private LocalDateTime orderedOn;
}
