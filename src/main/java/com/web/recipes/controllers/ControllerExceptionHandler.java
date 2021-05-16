package com.web.recipes.controllers;

import com.web.recipes.exceptions.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.thymeleaf.exceptions.TemplateInputException;


/**
 * @author martsiomchyk
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({BadRequestException.class, TemplateInputException.class})
    public String handleBadRequestException(Exception exception, Model model, ServerHttpResponse response) {
       log.error(exception.getClass() + exception.getMessage());
       
        HttpStatus responseStatus;
        String exceptionMessage;
        if (exception instanceof BadRequestException) {
            BadRequestException badRequestException = (BadRequestException) exception;
            responseStatus = badRequestException.getStatus();
            exceptionMessage = badRequestException.getReason();
        } else {
            responseStatus = HttpStatus.NOT_FOUND;
            exceptionMessage = exception.getMessage();
        }
        response.setStatusCode(responseStatus);
        model.addAttribute("status", responseStatus.toString());
        model.addAttribute("exception", exceptionMessage);
        return "bad-request";
    }
}
