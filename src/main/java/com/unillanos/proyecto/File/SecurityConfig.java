package com.unillanos.proyecto.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
  {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests((authz) ->
            authz.requestMatchers("/api/v1/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated())
        //.formLogin(Customizer.withDefaults())
        .build();
  }

}
