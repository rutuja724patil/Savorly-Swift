package com.Rutuja.Savorly.Swift.model;

import com.Rutuja.Savorly.Swift.dto.RestaurantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.cache.internal.StrategyCreatorRegionFactoryImpl;
import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private USER_ROLE role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    @ElementCollection
    private List<RestaurantDto>favorites = new ArrayList();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();


}
