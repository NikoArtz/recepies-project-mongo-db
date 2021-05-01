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
public class Category {
    private String id;
    private String description;

    private Set<Recipe> recipes = new HashSet<>();

}
