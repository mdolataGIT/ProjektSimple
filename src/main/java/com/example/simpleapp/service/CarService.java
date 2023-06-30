package com.example.simpleapp.service;

import com.example.simpleapp.domain.Car;
import com.example.simpleapp.domain.Client;
import com.example.simpleapp.exception.ClientIdException;
import com.example.simpleapp.repository.CarRepository;
import com.example.simpleapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;

    public Car addCar(Car car, Long clientId) {

        Client client = clientRepository.findClientById(clientId);

        if (client == null) {
            throw new ClientIdException("Client Id" + clientId + " does not exist");
        }

        car.setClient(client);

        return carRepository.save(car);

    }

    public Iterable<Car> findAllCars() {
        return carRepository.findAll();
    }
}
