package com.camarin.base.domain.services.auth;

import com.camarin.base.domain.dto.auth.AuthDto;
import com.camarin.base.domain.dto.auth.AuthResponseDto;

public interface IAuthService {
    public AuthResponseDto login(AuthDto authRequest) throws Exception;
}
