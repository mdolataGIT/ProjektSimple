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
public class EngineSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Capacity is required")
    private Integer capacity;

    @NotNull(message = "Power is required")
    private Integer power;

    @NotBlank(message = "Engine type is required")
    private String engineType;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Car car;
}
