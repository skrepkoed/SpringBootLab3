package com.example.demo2.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    @NotBlank
    private String uid;
    @NotBlank
    private String operationUid;
    @NotBlank
    private String operationTime;
    @NotBlank
    private String  systemTime;
    @NotBlank
    private String code;
    @NotBlank
    private String errorCode;
    @NotBlank
    private String errorMessage;
}
