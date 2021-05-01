package com.web.recipes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author martsiomchyk
 */

@Getter
@Setter
@NoArgsConstructor
public class Recipe {
    private String id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Notes notes;
    private Byte[] image;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Difficulty difficulty;
    private Set<Category> categories = new HashSet<>();

    public void addNotes(Notes notes) {
        this.notes = notes;
        notes.setRecipe(this);
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }
}
