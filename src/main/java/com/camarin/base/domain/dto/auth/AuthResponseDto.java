package com.camarin.base.domain.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDto {
    public AuthResponseDto(String token, String userName, String firstName, String lastName) {
        this.token = token;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String token;
    private String userName;
    private String firstName;
    private String lastName;
}
