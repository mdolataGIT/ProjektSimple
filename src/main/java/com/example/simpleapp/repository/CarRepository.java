package com.example.simpleapp.repository;

import com.example.simpleapp.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    @Override
    Iterable<Car> findAll();

}
