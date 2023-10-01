package com.example.demo2.service;

import org.springframework.validation.BindingResult;

import com.example.demo2.exception.ValidationFailedException;

public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
