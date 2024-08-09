package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.repository.MemberRepository;
import com.ohgiraffers.projectgin.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/register")
    public String register() { return "user/signup"; }

    @PostMapping("/register")
    public String register(MemberSignupDTO memberSignupDTO) {
        log.info("signup : {}",memberSignupDTO);
        memberService.register(memberSignupDTO);
        return "/auth/login";
    }

    @GetMapping("/mypage")
    public void mypage() {}

    @PostMapping("/modify")
    public String modifyUser(@ModelAttribute("member") MemberSignupDTO memberDTO,
                             RedirectAttributes redirectAttributes){
        try {
            memberService.updateMemberInfo(memberDTO);
            redirectAttributes.addFlashAttribute("message", "회원 정보가 성공적으로 수정되었습니다.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "회원 정보 수정 중 오류가 발생했습니다.");
        }
        return "/user/mypage";
    }

    @GetMapping("/main")
    public String mainPage(){ return "index"; }

    }
