package com.example.restaurantMenu;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    List<Dish> findByPrice(float price);
    List<Dish> findByName(String name);
}
