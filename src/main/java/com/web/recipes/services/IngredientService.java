package com.web.recipes.services;

import com.web.recipes.commands.IngredientCommand;

/**
 * @author martsiomchyk
 */

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(String recipeId, String ingredientId);
}
