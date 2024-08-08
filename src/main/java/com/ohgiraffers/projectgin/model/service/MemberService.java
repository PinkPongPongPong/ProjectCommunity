package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.entity.RoleType;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;



@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void register(MemberSignupDTO signupDTO) {
        MemberEntity memberEntity = MemberEntity.builder()
                .memberId(signupDTO.getMemberId())
                .memberNickName(signupDTO.getMemberNickName())
                .password(passwordEncoder.encode(signupDTO.getPassword())) // 암호화
                .name(signupDTO.getName())
                .phone(signupDTO.getPhone())
                .email(signupDTO.getEmail())
                .regDate(LocalDate.now())
                .role(RoleType.USER)
                .build();
        MemberEntity savedUser = memberRepository.save(memberEntity);
        log.info("저장된 회원 정보 : {}", savedUser.getMemberNo());
    }
    public boolean checkUserId(String memberId) {
        try {
            return memberRepository.existsByMemberId(memberId);
        } catch (Exception e) {
            log.error("Database error during member ID check", e);
            throw new RuntimeException("Database error", e);
        }
    }
    public boolean checkEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    public boolean checkPhone(String phone) {
        return memberRepository.existsByPhone(phone);
    }

    public boolean checkName(String name) {
        return memberRepository.existsByName(name);
    }

    public boolean checkUserNickName(String memberNickName) {
        return memberRepository.existsByMemberNickName(memberNickName);
    }

    public MemberEntity getCurrentMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null) {
            log.error("Authentication object is null or has no principal");
            throw new RuntimeException("No authenticated user found");
        }
        String username = authentication.getName();
        log.info("Authenticated username: {}", username);

        return memberRepository.findMemberEntityByMemberId(username)
                .orElseThrow(() -> {
                    log.error("User with ID {} not found in the database", username);
                    return new RuntimeException("User not found");
                });
    }

    @Transactional
    public void updateMyPage(MemberSignupDTO memberUpdateDTO) {
        MemberEntity memberEntity = memberRepository.findMemberEntityByMemberId(memberUpdateDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 빌더 패턴을 이용해 수정된 정보를 업데이트
        MemberEntity updatedMember = MemberEntity.builder()
                .password(memberUpdateDTO.getPassword() != null && !memberUpdateDTO.getPassword().isEmpty()
                        ? passwordEncoder.encode(memberUpdateDTO.getPassword())
                        : memberEntity.getPassword())
                .email(memberUpdateDTO.getEmail() != null ? memberUpdateDTO.getEmail() : memberEntity.getEmail())
                .phone(memberUpdateDTO.getPhone() != null ? memberUpdateDTO.getPhone() : memberEntity.getPhone())
                .name(memberUpdateDTO.getName() != null ? memberUpdateDTO.getName() : memberEntity.getName())
                .build();

        memberRepository.save(updatedMember);
        log.info("Updated user profile: {}", updatedMember.getMemberId());
    }

    public void updateProfile(MemberSignupDTO memberUpdateDTO) {
        MemberEntity memberEntity = memberRepository.findMemberEntityByMemberId(memberUpdateDTO.getMemberId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 빌더 패턴을 이용해 수정된 정보를 업데이트
        MemberEntity updatedMember = MemberEntity.builder()
                .password(memberUpdateDTO.getPassword() != null && !memberUpdateDTO.getPassword().isEmpty()
                        ? passwordEncoder.encode(memberUpdateDTO.getPassword())
                        : memberEntity.getPassword())
                .email(memberUpdateDTO.getEmail() != null ? memberUpdateDTO.getEmail() : memberEntity.getEmail())
                .phone(memberUpdateDTO.getPhone() != null ? memberUpdateDTO.getPhone() : memberEntity.getPhone())
                .name(memberUpdateDTO.getName() != null ? memberUpdateDTO.getName() : memberEntity.getName())
                .build();

        memberRepository.save(updatedMember);
        log.info("Updated user profile: {}", updatedMember.getMemberId());
    }
}


