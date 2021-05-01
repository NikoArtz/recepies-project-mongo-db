package com.web.recipes.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {
    Category category;

    @BeforeEach
    private void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        String testingId = "4";
        category.setId(testingId);
        assertEquals(testingId, category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }
}