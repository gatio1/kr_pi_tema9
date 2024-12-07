package com.example.restaurantMenu;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    List<Dish> findByPrice(BigDecimal price);
    List<Dish> findByName(String name);
}
