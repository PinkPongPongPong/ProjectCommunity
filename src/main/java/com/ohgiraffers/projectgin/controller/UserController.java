package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.MemberRepository;
import com.ohgiraffers.projectgin.model.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
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
    public String updateMyPage(@ModelAttribute("member") MemberEntity memberEntity , MemberSignupDTO memberSignupDTO) {
        try {
            // 회원 ID가 실제로 존재하는지 확인
            MemberEntity existingMemberEntity = memberService.findMemberById(memberEntity.getMemberId());

            // existingMemberEntity가 null이 아닌지 확인
            if (existingMemberEntity == null) {
                throw new IllegalArgumentException("회원을 찾을 수 없다.");
            }

            // DTO에서 새로운 정보로 업데이트
            existingMemberEntity.setMemberNickName(memberSignupDTO.getMemberNickName());
            existingMemberEntity.setPhone(memberSignupDTO.getPhone());
            existingMemberEntity.setEmail(memberSignupDTO.getEmail());

            // 회원 정보 업데이트
            memberService.updateMemberInfo(existingMemberEntity);

            // 성공 시 마이페이지로 리다이렉트
            return "redirect:/user/mypage";
        } catch (Exception e) {
            // 오류 발생 시 에러 페이지로 리다이렉트
            return "redirect:/user/mypage?error=true";
        }
    }
    @GetMapping("/main")
    public String mainPage(){ return "index"; }

    }
