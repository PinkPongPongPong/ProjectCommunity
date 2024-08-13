package com.ohgiraffers.projectgin.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // 시큐리티에서 특정 결로를 보안 검증에서 제외하는 코드
    // CSS, JS , IMAGES 같은 정적 자원들에 대한 보안 필터를 적용하지 않게 함.
    @Bean
    public WebSecurityCustomizer securityCustomizer() {
//        return new WebSecurityCustomizer() {
//            @Override
//            public void customize(WebSecurity web) {
//                web.ignoring().requestMatchers("/css/**", "/js/**","/images/**");
//            }
//        };
        return (web) -> web
                .ignoring()
                .requestMatchers
                        (PathRequest
                                .toStaticResources()
                                .atCommonLocations());
    }
    // Spring Security 에서 제공하는 인증, 인가를 위한 필처들의 모음
    // 기본적으로 제공하는 필터들이 있고, 커스첨 필터또한 적용 시킬 수 있다.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry
                    .requestMatchers("/","index.html").permitAll() // 모두에게 허용
                    .requestMatchers("/user/register").anonymous() // 비인증사용자만 허용
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
