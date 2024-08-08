package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final MemberService memberService;
    private final HttpSession httpSession;

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
    public String updateMyPage(@ModelAttribute MemberSignupDTO memberUpdateDTO) {
        memberService.updateMyPage(memberUpdateDTO);
        return "redirect:/user/mypage"; // 수정 후 마이페이지로 리다이렉트
    }
    @GetMapping("/editProfile")
    public void editProfile() {}

//    @GetMapping("/edit")
//    public String editProfile(Model model) {
//        // 현재 로그인된 사용자 정보를 가져와서 뷰에 전달
//        MemberEntity member = memberService.getCurrentMember();
//        model.addAttribute("member", member);
//        return "user/editProfile"; // 회원정보 수정 페이지로 이동
//    }

    @PostMapping("/edit")
    public String updateProfile(@ModelAttribute MemberSignupDTO memberUpdateDTO) {
        memberService.updateProfile(memberUpdateDTO);
        return "redirect:/user/mypage"; // 수정 후 마이페이지로 리다이렉트
    }
    }
