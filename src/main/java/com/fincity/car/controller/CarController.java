package com.fincity.car.controller;

import com.fincity.car.domain.Car;
import com.fincity.car.service.CarService;
import com.fincity.car.specification.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public Car create(Car car) {
        return carService.create(car);
    }

    @PutMapping
    public Car update(Car car) {
        return carService.update(car);
    }

    @GetMapping("{id}")
    public Car findById(@PathVariable(name = "id") Long id) throws Exception {
        return carService.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        carService.deleteById(id);
    }

    @GetMapping
    public Collection<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("search")
    public Page<Car> search(@ModelAttribute Car car, Pageable pageable) {
        Specification<Car> carSpecification = CarSpecification.search(car);
        return carService.search(carSpecification, pageable);
    }

}
