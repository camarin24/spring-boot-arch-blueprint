package com.camarin.base.domain.services.auth;

import com.camarin.base.domain.dto.UserDto;
import com.camarin.base.domain.dto.auth.AuthDto;
import com.camarin.base.domain.dto.auth.AuthResponseDto;
import com.camarin.base.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService userDetailsService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager, CustomUserDetailService userDetailsService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public AuthResponseDto login(AuthDto authRequest) throws Exception {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password", e);
        }

        final UserDto userDetails = (UserDto) this.userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String token = this.jwtUtil.generateToken(userDetails);
        return new AuthResponseDto(token, userDetails.getUsername(), userDetails.getFirstName(), userDetails.getLastName());
    }
}
