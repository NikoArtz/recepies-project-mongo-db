package com.web.recipes.controllers;

import com.web.recipes.exceptions.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author martsiomchyk
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

//    @ExceptionHandler(BadRequestException.class)
//    public ModelAndView handleBadRequestException(Exception exception, HttpServletResponse response) {
//        log.error(exception.getClass() + exception.getMessage());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("bad-request");
//
//        HttpStatus responseStatus;
//        String exceptionMessage;
//        if (exception instanceof BadRequestException) {
//            BadRequestException badRequestException = (BadRequestException) exception;
//            responseStatus = badRequestException.getStatus();
//            exceptionMessage = badRequestException.getReason();
//        } else {
//            responseStatus = HttpStatus.BAD_REQUEST;
//            exceptionMessage = exception.getMessage();
//        }
//        response.setStatus(responseStatus.value());
//        modelAndView.addObject("status", responseStatus.toString());
//        modelAndView.addObject("exception", exceptionMessage);
//        return modelAndView;
//    }
}
