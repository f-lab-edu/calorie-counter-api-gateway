package com.example.flabcaloriecountergateway.user.exception;

import org.springframework.http.HttpStatus;

public record ResponseDto(String message, HttpStatus statusCode) {

}
