package com.example.restaurantMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient addIngredient(Ingredient ingredient)
    {
        ingredient.setId(null); // Prevent modification of existing ingredient.
        if(ingredient.getName() == null)
            throw new BadInputException("Name of ingredient not ser.");
        return ingredientRepository.save(ingredient);
    }
}
