package com.example.simpleapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "VIN is required")
    private Integer vin;

    @NotBlank(message = "Colour is required")
    private String colour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Client client;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "car")
    @JsonIgnore
    private EngineSpecification engineSpecification;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "car")
    @JsonIgnore
    private Trade trade;
}
