package com.example.restaurantMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/v1/ingredient") // This means URL's start with /demo (after Application path)
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/add")
    public @ResponseBody Ingredient addIngredient(@RequestBody Ingredient ingredient)
    {

        if(ingredient == null)
            throw new BadInputException("Invalid ingredient");

        return ingredientService.addIngredient(ingredient);

    }
}
