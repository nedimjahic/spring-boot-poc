package com.acme.poc.SpringPocApplication.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    private final JwtTokenFilter jwtTokenFilter;

    public SecurityConfig(JwtTokenFilter jwtTokenFilter) {
        this.jwtTokenFilter = jwtTokenFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/auth/**", "/admin/**", "/api/**")
            .and()
            .authorizeRequests()
            .antMatchers("ui/login", "/ui/forgot", "ui/static/**", "/auth/**", "/*", "/v3/api-docs", "/swagger-ui.html").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/ui/login").permitAll()
            .and()
            .logout().logoutUrl("/ui/forgot").permitAll();

        // Add JWT token filter
        http.addFilterBefore(jwtTokenFilter, BasicAuthenticationFilter.class);
    }

}
