package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class CarRepository {

    private final List<Car> carData = new ArrayList<>();

    public Car create(Car car) {
        if (car.getCarId() == null || car.getCarId().isBlank()) {
            car.setCarId(UUID.randomUUID().toString());
        }

        carData.add(car);
        return car;
    }

    public List<Car> findAll() {
        return new ArrayList<>(carData);
    }

    public Car findById(String id) {
        return carData.stream()
                .filter(car -> car.getCarId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Car update(String id, Car updatedCar) {
        Car existing = findById(id);
        if (existing != null) {
            existing.setCarName(updatedCar.getCarName());
            existing.setCarColor(updatedCar.getCarColor());
            existing.setCarQuantity(updatedCar.getCarQuantity());
        }
        return existing;
    }

    public void delete(String id) {
        carData.removeIf(car -> car.getCarId().equals(id));
    }
}