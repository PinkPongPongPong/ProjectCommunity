package com.ohgiraffers.projectgin.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
1./auth/login 주소로 들어오는 요청을 시큐리티에 처리한다.
2.UserDetailsService 의 LoadUserByUserName 메서드가 실행, UserDetails 객체를 반환
3.UserDetails 의 정보는 Authentication 에 주입
4.Authentication SecurityContext
* */

@Controller
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @GetMapping("/login")
    public void login(){}

}
