package com.fincity.car.specification;

import com.fincity.car.domain.Car;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class CarSpecification {

    public static Specification<Car> search(Car car) {
        return (root, query, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (car != null) {
                if (car.getName() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("name"), car.getName()));
                }

                if (car.getManufactureName() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("manufactureName"), car.getManufactureName()));
                }

                if (car.getManufacturingYear() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("manufacturingYear"), car.getManufacturingYear()));
                }

                if (car.getModel() != null) {
                    predicates.add(criteriaBuilder.equal(root.get("model"), car.getModel()));
                }
            }
            return criteriaBuilder.and(predicates.stream().toArray(Predicate[]::new));
        };
    }
}
