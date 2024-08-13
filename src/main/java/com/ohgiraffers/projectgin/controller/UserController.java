package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.MemberRepository;
import com.ohgiraffers.projectgin.model.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    @Autowired
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

//    @Transactional
//    public String updateMember(String memberId, MemberSignupDTO memberDto) {
//        MemberEntity member = memberRepository.findMemberEntityByMemberId(memberId)
//                .orElseThrow(() -> new IllegalArgumentException("No member with id " + memberId));
//
//        MemberEntity updatedMember = member.update(
//                memberDto.getMemberNickName(),
//                memberDto.getEmail(),
//                memberDto.getPassword()
//        );
//
//        return memberRepository.save(updatedMember).getMemberId();
//    }

//    public MemberSignupDTO findMemberById(String memberId) {
//        MemberEntity member = memberRepository.findById(memberId)
//                .orElseThrow(() -> new IllegalArgumentException("No member with id " + memberId));
//
//        return MemberSignupDTO.builder()
//                .memberId(member.getMemberId())
//                .name(member.getName())
//                .email(member.getEmail())
//                .password(member.getPassword())
//                .build();
//    }


    @GetMapping("/main")
    public String main(){ return "/index"; }
    }


