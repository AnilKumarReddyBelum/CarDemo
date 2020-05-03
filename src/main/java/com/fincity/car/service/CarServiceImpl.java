package com.fincity.car.service;

import com.fincity.car.domain.Car;
import com.fincity.car.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findById(Long id) throws Exception {
        return carRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Collection<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> search(Specification<Car> search, Pageable pageable) {
        return carRepository.findAll(search, pageable);
    }
}


