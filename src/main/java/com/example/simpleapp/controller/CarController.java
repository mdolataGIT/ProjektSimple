package com.example.simpleapp.controller;

import com.example.simpleapp.domain.Car;
import com.example.simpleapp.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/{clientId}")
    public ResponseEntity<?> createCar(@Valid @RequestBody Car car, @PathVariable Long clientId) {
        return new ResponseEntity<>(carService.createCar(car, clientId), HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<Car> getAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/carsByBrandAndModel/{brand}/{model}")
    List<Car> getCarByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return carService.findCarByBrandAndModel(brand, model);
    }

    @GetMapping("/{carId}")
    public Car getCarById(@PathVariable Long carId) {
        return carService.findCarById(carId);
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<?> deleteCar(@PathVariable Long carId) {
        carService.deleteCarById(carId);
        return new ResponseEntity<>("Car was deleted", HttpStatus.OK);
    }

    @PatchMapping("/{carId}/{model}")
    public ResponseEntity<?> updateCarModel(@PathVariable Long carId, @PathVariable String model) {
        return new ResponseEntity<>(carService.updateCarModel(carId, model), HttpStatus.OK);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<?> updateCar(@Valid @RequestBody Car car, @PathVariable Long carId) {
        return new ResponseEntity<>(carService.updateCar(car, carId), HttpStatus.OK);
    }
}
