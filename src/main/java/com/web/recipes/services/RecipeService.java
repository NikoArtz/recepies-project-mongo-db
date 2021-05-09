package com.web.recipes.services;

import com.web.recipes.commands.RecipeCommand;
import com.web.recipes.domain.Recipe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecipeService {

    Flux<Recipe> getRecipes();

    Mono<Recipe> findById(String id);

    Mono<RecipeCommand> saveRecipeCommand(RecipeCommand recipeCommand);

    Mono<RecipeCommand> findCommandById(String id);

    Mono<Void> deleteById(String id);

}
