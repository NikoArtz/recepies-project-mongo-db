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
public class CategoryCommand {
    private String id;
    private String description;
}
