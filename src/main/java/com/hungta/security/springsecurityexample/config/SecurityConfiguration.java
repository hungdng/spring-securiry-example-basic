package com.hungta.security.springsecurityexample.config;

import com.sun.tracing.ProbeName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author HUNGTA on 01/01/18 - 12:43 PM
 * @project spring-security-example
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hungta").password("123").roles("USER").and()
                .withUser("demo").password("123").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                //.antMatchers("**/hello").hasRole("USER")
                //.antMatchers("**/rest/*")
                .anyRequest()
                .fullyAuthenticated()
                //.permitAll()
                .and()
                .httpBasic();
        httpSecurity.csrf().disable();
    }

    @Bean
    public CustomFilter customFilter() {
        return new CustomFilter();
    }
}
