package com.example.flabcaloriecountergateway.user.adapter.out.persistence;

import com.example.flabcaloriecountergateway.user.application.port.in.response.SignUpForm;
import com.example.flabcaloriecountergateway.user.domain.User;

public interface UserRepository {

    void signUp(final SignUpForm signUpForm);

    boolean hasDuplicatedId(final String userId);

    User findByUserId(String userId);
}
