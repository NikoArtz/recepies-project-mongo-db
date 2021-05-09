package com.web.recipes.services;

import com.web.recipes.commands.RecipeCommand;
import com.web.recipes.converters.RecipeCommandToRecipe;
import com.web.recipes.converters.RecipeToRecipeCommand;
import com.web.recipes.domain.Recipe;
import com.web.recipes.repositories.reactive.RecipeReactiveRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author martsiomchyk
 */
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeReactiveRepository recipeReactiveRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeReactiveRepository recipeReactiveRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeReactiveRepository = recipeReactiveRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Flux<Recipe> getRecipes() {
        return recipeReactiveRepository.findAll();
    }

    @Override
    public Mono<Recipe> findById(String id) {
        return recipeReactiveRepository.findById(id);
    }

    @Override
    @Transactional
    public Mono<RecipeCommand> saveRecipeCommand(RecipeCommand recipeCommand) {
        return recipeReactiveRepository.save(recipeCommandToRecipe.convert(recipeCommand)).map(recipeToRecipeCommand::convert);
    }

    @Override
    @Transactional
    public Mono<RecipeCommand> findCommandById(String id) {

        return recipeReactiveRepository.findById(id).
                map(recipe -> {
                    RecipeCommand recipeCommand = recipeToRecipeCommand.convert(recipe);
                    recipeCommand.getIngredients().forEach(rc -> rc.setRecipeId(recipeCommand.getId()));
                    return recipeCommand;
                });
    }

    @Override
    @Transactional
    public Mono<Void> deleteById(String id) {
        recipeReactiveRepository.deleteById(id).block();
        return Mono.empty();
    }
}
