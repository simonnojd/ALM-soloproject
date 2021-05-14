package com.example.springdocker;

import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
public class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Test
    void isCarDrivableTest() {
        Car car = new Car();
        car.setCanIDriveIt(true);
        carRepository.save(car);
        List<Car> actual = carRepository.findCarByCanIDriveIt(true);
        assertTrue(actual.get(0).isCanIDriveIt());
    }

}
