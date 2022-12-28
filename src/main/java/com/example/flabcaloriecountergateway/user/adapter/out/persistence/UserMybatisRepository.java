package com.example.flabcaloriecountergateway.user.adapter.out.persistence;
import com.example.flabcaloriecountergateway.user.application.port.in.response.SignUpForm;
import com.example.flabcaloriecountergateway.user.domain.JudgeStatus;
import com.example.flabcaloriecountergateway.user.domain.User;
import com.example.flabcaloriecountergateway.user.util.PasswordEncrypt;
import org.springframework.stereotype.Component;

@Component
public class UserMybatisRepository implements UserRepository {

    private final UserMapper userMapper;

    public UserMybatisRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void signUp(final SignUpForm signUpForm) {
        SignUpForm intermediateUserForm = new SignUpForm(
                signUpForm.userId(),
                signUpForm.userName(),
                PasswordEncrypt.encrypt(signUpForm.userPassword()),
                signUpForm.email(),
                signUpForm.weight(),
                signUpForm.userType(),
                JudgeStatus.getInitialJudgeStatusByUserType(signUpForm.userType())
        );

        this.userMapper.signUp(intermediateUserForm);
    }

    @Override
    public boolean hasDuplicatedId(final String userId) {
        return this.userMapper.hasDuplicatedId(userId);
    }

    @Override
    public User findByUserId(final String userId) {
        return this.userMapper.findByUserId(userId);
    }
}
