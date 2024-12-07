package com.example.restaurantMenu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    @Autowired IngredientRepository ingredientRepository;

    public List<Dish> getAllDishesByPrice(BigDecimal price){
        if(price.floatValue() <= 0)
        {
            throw new BadInputException("Invalid price");
        }
        price = price.setScale(2, RoundingMode.HALF_UP);  // Round to 2 decimal places

        List<Dish> ret = dishRepository.findByPrice(price);
        System.out.println("dishes: " + ret.toString() + "price: " + price);
        return ret;
    }

    public List<Dish> getAll()
    {
        Iterable<Dish> dishes = dishRepository.findAll();
        
        List<Dish> dishList = new ArrayList<>();

        dishes.forEach(dishList::add);
        return dishList;
    }

    public Dish editDish(int id, Dish dish){
        Optional<Dish> found = dishRepository.findById(id);
        Dish dishFound = found.get();

        dishFound.setName(dish.getName());
        dishFound.setPrice(dish.getPrice().setScale(2, RoundingMode.HALF_UP));
        dishFound.setWeight(Math.round(dish.getWeight()*100)/100.0f);
        // dishFound.
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Ingredient ingredient : dish.getIngredients()) {
                Optional<Ingredient> foundIngredient = ingredientRepository.findById(ingredient.getId());
            if (foundIngredient.isPresent()) {
                ingredientList.add(foundIngredient.get());
            } else {
                throw new BadInputException("Ingredient with ID " + ingredient.getId() + " not found.");
            }
        }

        dish.setIngredients(ingredientList);

        return dishRepository.save(dishFound);
    }

    public Dish addDish(Dish dish){
        List<Dish> found = dishRepository.findByName(dish.getName());
        if(found.size() != 0)
            throw new BadInputException("Name of dish is not unique");

        if(dish.getPrice().floatValue() <= 0 || dish.getWeight() <= 0)
        {
            throw new BadInputException("Invalid price or weight of dish.");
        }
        dish.setPrice(dish.getPrice().setScale(2, RoundingMode.HALF_UP));
        dish.setWeight(Math.round(dish.getWeight()*100)/100.0f);

        
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Ingredient ingredient : dish.getIngredients()) {
                Optional<Ingredient> foundIngredient = ingredientRepository.findById(ingredient.getId());
            if (foundIngredient.isPresent()) {
                ingredientList.add(foundIngredient.get());
            } else {
                throw new BadInputException("Ingredient with ID " + ingredient.getId() + " not found.");
            }
        }

        dish.setIngredients(ingredientList);

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


