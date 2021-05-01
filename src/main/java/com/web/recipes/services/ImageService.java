package com.web.recipes.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author martsiomchyk
 */
public interface ImageService {
    void saveImageFile(String recipeId, MultipartFile file);
}
