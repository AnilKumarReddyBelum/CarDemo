package com.fincity.car.service;

import com.fincity.car.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

public interface CarService {

    Car create(Car car);

    Car update(Car car);

    Car findById(Long id) throws Exception;

    void deleteById(Long id);

    Collection<Car> findAll();

    Page<Car> search(Specification<Car> search,
                     Pageable pageable);

}
