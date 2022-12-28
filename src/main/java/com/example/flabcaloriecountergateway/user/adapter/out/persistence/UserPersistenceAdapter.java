package com.example.flabcaloriecountergateway.user.adapter.out.persistence;

import com.example.flabcaloriecountergateway.user.application.port.in.response.SignUpForm;
import com.example.flabcaloriecountergateway.user.application.port.out.SignUpPort;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceAdapter implements SignUpPort {

    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUp(final SignUpForm signUpForm) {
        this.userRepository.signUp(signUpForm);
    }

    @Override
    public boolean hasDuplicatedId(final String userId) {
        return this.userRepository.hasDuplicatedId(userId);
    }
}
