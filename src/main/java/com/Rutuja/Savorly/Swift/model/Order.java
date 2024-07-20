package com.Rutuja.Savorly.Swift.model;

import com.Rutuja.Savorly.Swift.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User customer;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    private Long totalAmount;

    private String orderStatus;

    private Data createdAt;

    @ManyToOne
    private Address deliveryAddress;

    @OneToMany
    private List<OrderItem> items;

   // private Payment payment;

    private int totalItem;

    private int totalPrice;

}
