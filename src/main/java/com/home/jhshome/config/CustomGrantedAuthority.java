package com.home.jhshome.config;

import com.home.jhshome.app.data.user.Role;
import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthority implements GrantedAuthority {
    private String authority;

    public CustomGrantedAuthority(String authority){
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        if (this.authority != null && Role.isValidRoleString(this.authority)){
            return this.authority;
        }
        return null;
    }
}
