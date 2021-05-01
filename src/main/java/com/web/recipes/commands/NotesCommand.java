package com.web.recipes.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author martsiomchyk
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private String id;
    private RecipeCommand recipe;
    private String recipeNotes;

}
