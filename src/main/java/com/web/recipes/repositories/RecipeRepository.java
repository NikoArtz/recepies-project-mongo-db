package com.web.recipes.repositories;

import com.web.recipes.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


/**
 * @author martsiomchyk
 */

public interface RecipeRepository extends CrudRepository<Recipe, String> {
}
