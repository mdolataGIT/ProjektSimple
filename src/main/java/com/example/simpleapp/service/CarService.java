package com.example.simpleapp.service;

import com.example.simpleapp.domain.Car;
import com.example.simpleapp.domain.Client;
import com.example.simpleapp.exception.ClientIdException;
import com.example.simpleapp.repository.CarRepository;
import com.example.simpleapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Car findCarById(Long carId) {
        return carRepository.findCarById(carId);
    }

    public void deleteCarById(Long carId) {
        carRepository.delete(findCarById(carId));
    }

    public Car updateCarModel(Long carId, String model) {
        Car car = findCarById(carId);
        car.setModel(model);

        return carRepository.save(car);
    }

    public Car updateCar(Car car, Long carId) {
        Car currentCar = carRepository.findCarById(carId);
        currentCar.setBrand(car.getBrand());
        currentCar.setModel(car.getModel());

        return carRepository.save(currentCar);
    }

    public List<Car> findCarByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }
}
