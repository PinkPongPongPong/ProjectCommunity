package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final MemberService memberService;

    @GetMapping("/register")
    public String register() { return "user/signup"; }

//    @PostMapping("/register")
//    public String register(UserSignupDTO userSignupDTO) {
//        log.info("signup : {}",userSignupDTO);
//        userService.register(userSignupDTO);
//        return "/auth/login";
//    }

//    @PostMapping("/register")
//    public String register(UserSignupDTO userSignupDTO, Model model) {
//        log.info("signup : {}", userSignupDTO);
//        try {
//            userService.register(userSignupDTO);
//            return "redirect:/auth/login";  // 가입 성공 시 로그인 페이지로 리다이렉트
//        } catch (IllegalArgumentException e) {
//            model.addAttribute("errorMessage", e.getMessage());  // 에러 메시지 추가
//            return "user/signup";  // 가입 실패 시 다시 회원가입 페이지로 이동
//        }
//    }
@PostMapping("/register")
public String register(MemberSignupDTO memberSignupDTO, Model model) {
    log.info("signup : {}", memberSignupDTO);

    boolean hasError = false;

    // 각 필드의 중복을 체크
    if (memberService.checkUserId(memberSignupDTO.getMemberId())) {
        model.addAttribute("idErrorMessage", "중복된 아이디입니다.");
        hasError = true;
    }
    if (memberService.checkEmail(memberSignupDTO.getEmail())) {
        model.addAttribute("emailErrorMessage", "중복된 이메일입니다.");
        hasError = true;
    }
    if (memberService.checkPhone(memberSignupDTO.getPhone())) {
        model.addAttribute("phoneErrorMessage", "중복된 전화번호입니다.");
        hasError = true;
    }
    if (memberService.checkName(memberSignupDTO.getName())) {
        model.addAttribute("nameErrorMessage", "중복된 이름입니다.");
        hasError = true;
    }
    if (memberService.checkUserNickName(memberSignupDTO.getMemberNickName())) {
        model.addAttribute("nickNameErrorMessage", "중복된 닉네임입니다.");
        hasError = true;
    }

    if (hasError) {
        return "member/signup";  // 에러가 있으면 다시 회원가입 페이지로 이동
    }

    try {
        memberService.register(memberSignupDTO);
        return "redirect:/auth/login";  // 가입 성공 시 로그인 페이지로 리다이렉트
    } catch (IllegalArgumentException e) {
        model.addAttribute("errorMessage", e.getMessage());  // 예외 발생 시 에러 메시지 추가
        return "member/signup";  // 가입 실패 시 다시 회원가입 페이지로 이동
    }
}
    @GetMapping("/mypage")
    public void mypage() {}

    @GetMapping("/check-id")
    @ResponseBody
    public ResponseEntity<Boolean> checkUserIdDuplicate(@RequestParam("memberId") String memberId) {
        try {
            boolean isTaken = memberService.checkUserId(memberId);
            return ResponseEntity.ok(isTaken);
        } catch (Exception e) {
            log.error("Error checking member ID", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/check-email")
    @ResponseBody
    public ResponseEntity<Boolean> checkEmailDuplicate(@RequestParam("email") String email) {
        try {
            boolean isTaken = memberService.checkEmail(email);
            return ResponseEntity.ok(isTaken);
        } catch (Exception e) {
            log.error("Error checking email", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/check-phone")
    @ResponseBody
    public ResponseEntity<Boolean> checkPhoneDuplicate(@RequestParam("phone") String phone) {
        try {
            boolean isTaken = memberService.checkPhone(phone);
            return ResponseEntity.ok(isTaken);
        } catch (Exception e) {
            log.error("Error checking phone", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/check-name")
    @ResponseBody
    public ResponseEntity<Boolean> checkNameDuplicate(@RequestParam("name") String name) {
        try {
            boolean isTaken = memberService.checkName(name);
            return ResponseEntity.ok(isTaken);
        } catch (Exception e) {
            log.error("Error checking name", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/check-memberNickName")
    @ResponseBody
    public ResponseEntity<Boolean> checkUserNickNameDuplicate(@RequestParam("memberNickName") String memberNickName) {
        try {
            boolean isTaken = memberService.checkUserNickName(memberNickName);
            return ResponseEntity.ok(isTaken);
        } catch (Exception e) {
            log.error("Error checking member nickname", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    }
