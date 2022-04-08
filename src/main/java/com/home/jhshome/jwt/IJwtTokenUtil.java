package com.home.jhshome.jwt;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface IJwtTokenUtil {
    public abstract String doGenerateToken(UserDetails userDetails);

    public boolean isTokenExpired(String token);

    public boolean isValidToken(String token);

}
