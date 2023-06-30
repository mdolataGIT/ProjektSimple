package com.example.simpleapp.service;

import com.example.simpleapp.domain.Car;
import com.example.simpleapp.domain.Client;
import com.example.simpleapp.repository.CarRepository;
import com.example.simpleapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;

    public Car addCar(Car car, Long clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        car.setClient(client.get());

        return carRepository.save(car);
    }
}
