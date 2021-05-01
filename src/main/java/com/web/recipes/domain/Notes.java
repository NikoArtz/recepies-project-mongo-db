package com.web.recipes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * @author martsiomchyk
 */

@Getter
@Setter
@NoArgsConstructor
public class Notes {
    @Id
    private String id;
    private Recipe recipe;
    private String recipeNotes;

}
