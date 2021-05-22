package com.gocoding.noticeboard.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user",true);
        http
                .logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login");

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll();
        http
                .csrf().disable();

        //http.userDetailsService(securityUserDetailsService);

        http
                .sessionManagement()
                .maximumSessions(1);

    }
}
