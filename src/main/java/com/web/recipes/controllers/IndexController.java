package com.web.recipes.controllers;

import com.web.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author martsiomchyk
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "index"})
    public String getIndexPage(Model model) {
        log.debug("Indexing main page");
        model.addAttribute("recipes", recipeService.getRecipes().collectList().share().block());
        return "index";
    }
}
