package com.web.recipes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author martsiomchyk
 */

@Getter
@Setter
@NoArgsConstructor
public class Notes {
    private String id;
    private Recipe recipe;
    private String recipeNotes;

}
