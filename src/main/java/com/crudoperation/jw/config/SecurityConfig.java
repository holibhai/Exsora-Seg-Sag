package com.crudoperation.jw.config;

import com.crudoperation.jw.filter.JwtAuthenticationFilter;
import com.crudoperation.jw.service.serviceImp.UserDetailsImp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableAspectJAutoProxy
public class SecurityConfig {
    private final UserDetailsImp userDetailsImp;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UserDetailsImp userDetailsImp, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailsImp = userDetailsImp;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http

                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        req->req.requestMatchers("/h2-console/**","/login/**","/api/**", "/refresh_token/**","/api/order/**")
                                .permitAll()
                                .requestMatchers("/admin_only/**").hasAuthority("ADMIN")
//                                .requestMatchers("/api/**").hasAuthority("USER")
                                .anyRequest()
                                .authenticated()
                ).userDetailsService(userDetailsImp)
                .sessionManagement(session->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore( jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .cors(cors->cors.configurationSource(corsConfigurationSource()))

                .build();

    }
    private CorsConfigurationSource corsConfigurationSource(){
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration configuration=new CorsConfiguration();
                configuration.setAllowCredentials(true);
                configuration.setMaxAge(3600L);
                configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:5173","http://localhost:5175","http://localhost:8081"));
                configuration.setAllowedMethods(Collections.singletonList("*"));
                configuration.setAllowedHeaders(Collections.singletonList("*"));
                return configuration;
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
