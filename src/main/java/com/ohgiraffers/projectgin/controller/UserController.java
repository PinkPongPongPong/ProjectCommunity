package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.repository.MemberRepository;
import com.ohgiraffers.projectgin.model.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

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
    private final HttpSession httpSession;

    @GetMapping("/register")
    public String register() {
        return "user/signup";
    }

    @PostMapping("/register")
    public String register(MemberSignupDTO memberSignupDTO) {

        log.info("signup : {}", memberSignupDTO);
        memberService.register(memberSignupDTO);
        return "/auth/login";
    }

    @GetMapping("/mypage")
    public void mypage() {
    }


    @PostMapping("/modify")

    public String updateMyPage(@ModelAttribute("member") MemberEntity memberEntity,
                               RedirectAttributes redirectAttributes) {
        try {
            // 현재 로그인한 사용자 정보 가져오기
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String loggedInUserId = ((UserDetails) authentication.getPrincipal()).getUsername();

            // 로그인한 사용자 ID로 회원 정보 조회
            MemberEntity existingMemberEntity = memberService.findMemberById(loggedInUserId);

            // 기존 정보를 업데이트할 값으로 변경
            existingMemberEntity.setMemberNickName(memberEntity.getMemberNickName());
            existingMemberEntity.setPhone(memberEntity.getPhone());
            existingMemberEntity.setEmail(memberEntity.getEmail());

            // 회원 정보 업데이트
            memberService.updateMemberInfo(existingMemberEntity);

            // 성공 시 마이페이지로 리다이렉트
            return "redirect:/user/mypage";
        } catch (Exception e) {
            // 오류 발생 시 에러 페이지로 리다이렉트
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/user/mypage?error=true";
        }

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
