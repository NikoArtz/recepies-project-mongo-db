package com.web.recipes.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * @author martsiomchyk
 */

@Getter
@Setter
@NoArgsConstructor
@Document
public class Category {
    @Id
    private String id;
    private String description;
    @DBRef
    private Set<Recipe> recipes = new HashSet<>();

}
