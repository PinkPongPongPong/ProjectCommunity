package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.UserSignupDTO;
import com.ohgiraffers.projectgin.model.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String register() { return "user/signup"; }

    @PostMapping("/register")
    public String register(UserSignupDTO userSignupDTO) {
        log.info("signup : {}",userSignupDTO);
        userService.register(userSignupDTO);
        return "/";
    }
}
