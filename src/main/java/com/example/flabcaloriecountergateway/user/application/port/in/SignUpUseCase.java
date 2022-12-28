package com.example.flabcaloriecountergateway.user.application.port.in;

import com.example.flabcaloriecountergateway.user.application.port.in.response.SignUpForm;

public interface SignUpUseCase {

    void signUp(final SignUpForm signUpForm);
}
