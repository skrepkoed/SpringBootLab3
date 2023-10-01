package com.example.demo2.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.exception.ValidationFailedException;
import com.example.demo2.model.Request;
import com.example.demo2.model.Response;
import com.example.demo2.service.ValidationService;
import com.example.demo2.util.DateTimeUtil;

@RestController
public class MyController {
    private final ValidationService validationService;

    public MyController(ValidationService validationService){
        this.validationService=validationService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult ){
        Response response =  Response.builder()
        .uid(request.getUid())
        .operationUid(request.getOperationUid())
        .systemTime(DateTimeUtil.getSimpleDateTimeFormat().format(new Date()))
        .code("success")
        .errorCode("")
        .errorMessage("")
        .build();

        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка валидации");
            return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            response.setCode("failed");
            response.setErrorCode("UnknownException");
            response.setErrorMessage("Произошла непредвиденная ошибка");
            return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
