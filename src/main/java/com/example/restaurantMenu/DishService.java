package com.example.restaurantMenu;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishesByPrice(float price){
        if(price <= 0)
        {
            throw new BadInputException("Invalid price");
        }
        price = Math.round(price * 100) / 100.0f;  // Round to 2 decimal places

        return dishRepository.findByPrice(price);
    }

    public Dish editDish(Dish dish){
        Optional<Dish> found = dishRepository.findById(dish.getId());
        Dish dishFound = found.get();

        dishFound.setName(dish.getName());
        dishFound.setPrice(Math.round(dish.getPrice()*100)/100.0f);
        dishFound.setWeight(Math.round(dish.getWeight()*100)/100.0f);

        return dishRepository.save(dishFound);
    }

    public Dish addDish(Dish dish){
        List<Dish> found = dishRepository.findByName(dish.getName());
        if(found.size() != 0)
            throw new BadInputException("Name of dish is not unique");

        if(dish.getPrice() <= 0 || dish.getWeight() <= 0)
        {
            throw new BadInputException("Invalid price or weight of dish.");
        }
        return dishRepository.save(dish);
    }

    public void deleteDish(Integer id){
        Optional<Dish> found = dishRepository.findById(id);
        if(found.isEmpty())
            throw new BadInputException("Dish not found.");
        Dish dishFound = found.get();

        dishRepository.delete(dishFound);
        return;
    }
}


