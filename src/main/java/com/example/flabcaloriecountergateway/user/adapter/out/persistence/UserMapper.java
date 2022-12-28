package com.example.flabcaloriecountergateway.user.adapter.out.persistence;

import com.example.flabcaloriecountergateway.user.application.port.in.response.SignUpForm;
import com.example.flabcaloriecountergateway.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void signUp(final SignUpForm signUpForm);

    boolean hasDuplicatedId(final String userId);

    User findByUserId(final String userId);
}
