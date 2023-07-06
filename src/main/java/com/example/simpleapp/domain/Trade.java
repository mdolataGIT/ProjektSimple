package com.example.simpleapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Value is required")
    private Integer value;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private LocalDate purchaseDate;

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Car car;
}
