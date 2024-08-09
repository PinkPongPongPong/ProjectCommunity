package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.RoleType;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.BoardRepository;
import com.ohgiraffers.projectgin.model.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.nio.file.NoSuchFileException;
import java.time.LocalDate;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final BoardRepository boardRepository;


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

    public MemberEntity findMemberById(String memberId) throws NoSuchFileException {
        MemberEntity member = memberRepository.findMemberEntityByMemberId(memberId)
                .orElseThrow(() -> new NoSuchFileException("회원을 찾을 수 없습니다."));

        return member;


    }
}


