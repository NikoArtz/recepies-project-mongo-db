package com.web.recipes.services;

import com.web.recipes.commands.IngredientCommand;
import reactor.core.publisher.Mono;

/**
 * @author martsiomchyk
 */

public interface IngredientService {
    Mono<IngredientCommand> findByRecipeIdAndIngredientId(String recipeId, String ingredientId);

    Mono<IngredientCommand> saveIngredientCommand(IngredientCommand command);

    Mono<Void> deleteById(String recipeId, String ingredientId);
}
