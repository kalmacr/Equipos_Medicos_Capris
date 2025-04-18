/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.EquiposMedicos.controller;

import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Maneja errores 404 - Recurso no encontrado
    @ExceptionHandler({NoHandlerFoundException.class, EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundError(Exception ex, Model model) {
        logger.error("Recurso no encontrado: {}", ex.getMessage());
        model.addAttribute("errorCode", "404");
        model.addAttribute("errorMessage", "El recurso solicitado no fue encontrado");
        model.addAttribute("errorDetails", ex.getMessage());
        return "error/error-page";
    }

    // Maneja errores de base de datos
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleDatabaseError(DataAccessException ex, Model model) {
        logger.error("Error de base de datos: {}", ex.getMessage(), ex);
        model.addAttribute("errorCode", "500");
        model.addAttribute("errorMessage", "Error en la base de datos");
        model.addAttribute("errorDetails", "Ocurrió un problema al acceder a los datos. Por favor, inténtelo de nuevo más tarde.");
        return "error/error-page";
    }

    // Maneja errores de validación de formularios
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidationErrors(Exception ex, Model model) {
        Map<String, String> errors = new HashMap<>();
        
        if (ex instanceof MethodArgumentNotValidException) {
            ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        } else if (ex instanceof BindException) {
            ((BindException) ex).getBindingResult().getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        }
        
        logger.error("Errores de validación: {}", errors);
        model.addAttribute("errorCode", "400");
        model.addAttribute("errorMessage", "Error en los datos enviados");
        model.addAttribute("validationErrors", errors);
        return "error/validation-error";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGenericException(Exception ex, Model model) {
        logger.error("Error inesperado: {}", ex.getMessage(), ex);
        model.addAttribute("errorCode", "500");
        model.addAttribute("errorMessage", "Error interno del servidor");
        model.addAttribute("errorDetails", "Ha ocurrido un error inesperado. Nuestro equipo técnico ha sido notificado.");
        return "error/error-page";
    }
}