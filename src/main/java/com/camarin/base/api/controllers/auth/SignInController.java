package com.camarin.base.api.controllers.auth;

import com.camarin.base.domain.dto.auth.AuthDto;
import com.camarin.base.domain.dto.auth.AuthResponseDto;
import com.camarin.base.domain.services.auth.IAuthService;
import com.camarin.base.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/auth")
public class SignInController {
    private final IAuthService authService;

    @Autowired
    public SignInController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/login")
    public AuthResponseDto login(@RequestBody AuthDto authRequest) throws Exception {
        return this.authService.login(authRequest);
    }
}
