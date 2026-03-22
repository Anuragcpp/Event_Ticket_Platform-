package com.event.platform.ticktes.security.config;

import com.event.platform.ticktes.security.JwtAuthenticationFilter;
import com.event.platform.ticktes.security.authenticationExcrption.CustomeAccessDeniedHandler;
import com.event.platform.ticktes.security.authenticationExcrption.CustomeAutheticationEntrypoint;
import com.event.platform.ticktes.user.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {


    //private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity httpSecurity ,
            JwtAuthenticationFilter jwtAuthenticationFilter,
            CustomeAutheticationEntrypoint customeAutheticationEntrypoint,
            CustomeAccessDeniedHandler customeAccessDeniedHandler
    ) throws Exception{

        log.debug("auth  filter activiated");
        httpSecurity
                .csrf(cref -> cref.disable())
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers( HttpMethod.POST,"/api/v1/auth/signup").permitAll()
                                .anyRequest()
                                .authenticated()
                        )
//                .exceptionHandling(ex -> ex
//                        .authenticationEntryPoint(customeAutheticationEntrypoint)
//                        .accessDeniedHandler(customeAccessDeniedHandler)
//                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
