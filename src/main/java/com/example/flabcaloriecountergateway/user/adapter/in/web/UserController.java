package com.example.flabcaloriecountergateway.user.adapter.in.web;

import com.example.flabcaloriecountergateway.user.application.port.in.SignUpUseCase;
import com.example.flabcaloriecountergateway.user.application.port.in.response.SignUpForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.flabcaloriecountergateway.user.adapter.in.web.Constants.LATEST_API_VERSION;

@RestController
public class UserController {

    private final SignUpUseCase signUpUseCase;

    public UserController(SignUpUseCase signUpUseCase) {
        this.signUpUseCase = signUpUseCase;
    }

    @PostMapping(LATEST_API_VERSION + "/users")
    public ResponseEntity<SignUpForm> signUpSubmit(
            @RequestHeader("x-user-id") @RequestBody @Valid final SignUpForm signUpForm) {
        this.signUpUseCase.signUp(signUpForm);
        return new ResponseEntity<>(signUpForm, HttpStatus.CREATED);
    }
}
