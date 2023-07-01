package com.example.simpleapp.service;

import com.example.simpleapp.domain.Car;
import com.example.simpleapp.domain.Client;
import com.example.simpleapp.exception.CarIdException;
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

    @Autowired
    ClientService clientService;

    public Car addCar(Car car, Long clientId) {
        Client client = clientService.findClientById(clientId);
        car.setClient(client);

        return carRepository.save(car);
    }

    public Iterable<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Car findCarById(Long carId) {
        Car car = carRepository.findCarById(carId);

        if (car == null) {
            throw new CarIdException("Car ID '" + carId + "' does not exist");
        }

        return car;
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
        Car currentCar = findCarById(carId);
        currentCar.setBrand(car.getBrand());
        currentCar.setModel(car.getModel());
        currentCar.setVin(car.getVin());
        currentCar.setColour(car.getColour());

        return carRepository.save(currentCar);
    }

    public List<Car> findCarByBrandAndModel(String brand, String model) {
        List<Car> carsByBrandAndModel = carRepository.findByBrandAndModel(brand, model);

        if (carsByBrandAndModel.isEmpty()) {
            throw new CarIdException("Cars with brand '" + brand + "and model '" + model + "' does not exist");
        }
        return carsByBrandAndModel;
    }
}
