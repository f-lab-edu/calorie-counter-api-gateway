package com.example.flabcaloriecountergateway.user.application.service;

import com.example.flabcaloriecountergateway.user.application.port.in.SignUpUseCase;
import com.example.flabcaloriecountergateway.user.application.port.in.response.SignUpForm;
import com.example.flabcaloriecountergateway.user.application.port.out.SignUpPort;
import com.example.flabcaloriecountergateway.user.exception.HasDuplicatedIdException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService implements SignUpUseCase {

    private final SignUpPort signUpPort;

    public SignUpService(SignUpPort signUpPort) {
        this.signUpPort = signUpPort;
    }

    @Override
    @Transactional
    public void signUp(final SignUpForm signUpForm) {
        if (this.signUpPort.hasDuplicatedId(signUpForm.userId())) {
            throw new HasDuplicatedIdException("이미 존재하는 ID입니다");
        }

        this.signUpPort.signUp(signUpForm);
    }
}
