package com.example.flabcaloriecountergateway.user.application.port.in.response;

import com.example.flabcaloriecountergateway.user.domain.JudgeStatus;
import com.example.flabcaloriecountergateway.user.domain.UserType;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public record SignUpForm(
        @NotBlank @Size(min = 6, max = 20) @Pattern(regexp = userIdPattern)
        String userId,
        @NotBlank @Size(min = 1, max = 20) @Pattern(regexp = namePattern)
        String userName,
        @NotBlank @Size(min = 8, max = 25) @Pattern(regexp = passwordPattern)
        String userPassword,
        @NotBlank @Email
        String email,

        @NotNull @NumberFormat
        Double weight,

        @NotNull
        UserType userType,

        @NotNull
        JudgeStatus judgeStatus
) {

    public static final String userIdPattern = "^[a-zA-Z0-9가-힣]+$";
    public static final String namePattern = "^[가-힣|a-zA-Z]+$";
    public static final String passwordPattern = "^[a-zA-Z0-9]+$";
}
