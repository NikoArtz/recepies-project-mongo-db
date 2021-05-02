package com.web.recipes.commands;


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
public class UnitOfMeasureCommand {
    @Id
    private String id;
    private String description;

}
