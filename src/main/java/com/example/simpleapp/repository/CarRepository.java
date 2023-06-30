package com.example.simpleapp.repository;

import com.example.simpleapp.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    Iterable<Car> findAll();

    Car findCarById(Long carId);

    List<Car> findByBrand (String brand);
}
