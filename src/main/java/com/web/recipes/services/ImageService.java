package com.web.recipes.services;

import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

/**
 * @author martsiomchyk
 */
public interface ImageService {
    Mono<Void> saveImageFile(String recipeId, MultipartFile file);
}
