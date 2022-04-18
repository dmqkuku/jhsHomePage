package com.home.jhshome.config;

import com.home.jhshome.app.data.user.Role;
import com.home.jhshome.app.data.user.UserDTO;
import com.home.jhshome.app.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//https://www.toptal.com/spring/spring-security-tutorial
@Configuration
@EnableWebSecurity
public class SpringSecurityWebConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint(){
        return new CustomAuthEntryPoint();
    }
    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }

    @Autowired
    public SpringSecurityWebConfig(UserService userService){
        this.userService = userService;
    }

    private UserDetails convertUserInfo2UserDetails(Optional<? extends UserDTO> optional){
        // assert 가 거짓이 되면 에러!~
        // elem supposed to be one

        assert optional.isPresent();

        var userInfo = optional.get();

        List<CustomGrantedAuthority> authList = new ArrayList<>();
        authList.add(new CustomGrantedAuthority(userInfo.getRole().name()));

        return new User(userInfo.getName(), userInfo.getPwd(), authList);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> convertUserInfo2UserDetails(userService.findUserDTOByNameEquals(username)));
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/user/**").hasAuthority(Role.USER.name())
                .antMatchers("/sa/**").hasAuthority(Role.SUPER_ADMIN.name())
                .antMatchers("/admin/**").hasAuthority(Role.ADMIN.name())
                .antMatchers("/home/**").permitAll()
                .antMatchers("/publicSpace/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint()).accessDeniedHandler(accessDeniedHandler());

    }
}
