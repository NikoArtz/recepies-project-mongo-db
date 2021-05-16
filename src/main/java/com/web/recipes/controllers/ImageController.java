package com.web.recipes.controllers;

import com.web.recipes.commands.RecipeCommand;
import com.web.recipes.services.ImageService;
import com.web.recipes.services.RecipeService;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.io.IOException;

/**
 * @author martsiomchyk
 */

@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(id).share().block());
        return "recipe/image-upload-form";
    }

    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("image-file") MultipartFile file) {
        imageService.saveImageFile(id, file).share().block();
        return "redirect:/recipe/" + id + "/show";
    }

    @GetMapping("recipe/{id}/recipe-image")
    public Mono<Void> renderImageFromDB(@PathVariable String id, ServerHttpResponse response) throws IOException {
        RecipeCommand recipeCommand = recipeService.findCommandById(id).share().block();
        if (recipeCommand.getImage() != null) {
            byte[] byteArray = new byte[recipeCommand.getImage().length];
            int i = 0;
            for (Byte wrappedByte : recipeCommand.getImage()) {
                byteArray[i++] = wrappedByte;
            }
            response.getHeaders().setContentType(MediaType.IMAGE_JPEG);
            response.setStatusCode(HttpStatus.OK);
            DataBuffer buffer = new DefaultDataBufferFactory().wrap(byteArray);
            return response.writeWith(Flux.just(buffer));
        }
        return Mono.empty();
    }
}
