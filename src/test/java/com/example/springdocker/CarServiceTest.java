package com.example.springdocker;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import com.example.springdocker.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    CarRepository carRepository;
    CarService carService;

    @BeforeEach
    void init() {
        carService = new CarService(carRepository);
    }

    @Test
    void getCarsTest() {
        assertEquals(carRepository.findAll(), carService.getCars());
    }

    @Test
    void saveCarTest() {
        Car car = new Car();
        car.setCanIDriveIt(false);
        car.setName("Lambo");
        car.setFast(true);
        car.setId("2");

        when(carRepository.save(any())).thenReturn(car);

        Car actualCar = carService.saveNewCar(car);
        assertEquals(car, actualCar);
    }

    @Test
    void checkIfCarIsDrivable() {
        Car car = new Car();
        car.setId("1");
        car.setName("Corvette");
        car.setFast(true);
        car.setCanIDriveIt(true);

        when(carRepository.findCarByCanIDriveIt(true)).thenReturn(Arrays.asList(car));

        List<String> drivableCars = carService.getDrivableCars();

        assertEquals(car.getName(), drivableCars.get(0));

    }
}
