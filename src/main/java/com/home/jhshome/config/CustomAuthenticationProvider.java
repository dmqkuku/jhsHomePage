package com.home.jhshome.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //usernamePasswordAuthenticationToken extends AbstractAuthenticationToken
        //AbstractAuthenticationToken extends Authentication
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
