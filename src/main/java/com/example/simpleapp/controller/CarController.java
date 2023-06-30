package com.example.simpleapp.controller;

import com.example.simpleapp.domain.Car;
import com.example.simpleapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/{clientId}")
    public ResponseEntity<?> addCar(@Valid @RequestBody Car car, @PathVariable Long clientId) {
        return new ResponseEntity<Car>(carService.addCar(car, clientId), HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<Car> getAllCars() {
        return carService.findAllCars();
    }
}
