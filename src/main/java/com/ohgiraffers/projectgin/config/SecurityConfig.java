package com.ohgiraffers.projectgin.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public WebSecurityCustomizer securityCustomizer() {
        return (web) -> web
                .ignoring()
                .requestMatchers
                        (PathRequest
                                .toStaticResources()
                                .atCommonLocations());
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry
                    .requestMatchers("/","index.html").permitAll() // 모두에게 허용
                    .requestMatchers("/member/register").anonymous() // 비인증사용자만 허용
                    .requestMatchers("/post/**").authenticated()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated(); // 인증된 사용자만 요청가능
        }));
        // form login 설정
        httpSecurity.formLogin((formLoginConfigurer -> {
            formLoginConfigurer
                    .loginPage("/auth/login") // 로그인 페이지 (GET)
                    .loginProcessingUrl("/auth/login") // 로그인처리 (Post)
                    .usernameParameter("memberId") // username 으로 전달할 파라미터
                    .passwordParameter("password") // password 로 전달할 파라미터
                    .defaultSuccessUrl("/") // 로그인 성공시 이동할 url
                    .permitAll();
        }));
        httpSecurity.logout(logoutConfigurer ->{
            logoutConfigurer
                    .logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/");
        });

        return httpSecurity.build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
