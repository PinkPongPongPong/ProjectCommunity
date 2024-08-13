package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.entity.RoleType;
import com.ohgiraffers.projectgin.model.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.NoSuchElementException;



@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = false)
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

    public MemberEntity findMemberById(String memberId) {

        log.info("service memberId : {}", memberId);
        MemberEntity memberEntity = memberRepository.findMemberEntityByMemberId(memberId)
                .orElseThrow(() -> new NoSuchElementException("회원이 없습니다."));

        return  memberEntity;
    }

    public void updateMemberInfo(MemberEntity memberEntity) {

//         DB 에서 현재 회원 정보 조회
        MemberEntity existingMemberEntity = findMemberById(memberEntity.getMemberId());
        log.info("get member : {}",memberEntity);

        // ID 업데이트
        if (memberEntity.getMemberId() != null && !memberEntity.getMemberId().equals(memberEntity.getMemberId())) {
            memberEntity.setMemberId(memberEntity.getMemberId());
        }

        // 닉네임 업데이트
        if (memberEntity.getMemberNickName() != null && !memberEntity.getMemberNickName().equals(memberEntity.getMemberNickName())) {
            memberEntity.setMemberNickName(memberEntity.getMemberNickName());
        }

        // 전화번호 업데이트
        if (memberEntity.getPhone() != null && !memberEntity.getPhone().equals(memberEntity.getPhone())) {
            memberEntity.setPhone(memberEntity.getPhone());
        }

        // 이메일 업데이트
        if (memberEntity.getEmail() != null && !memberEntity.getEmail().equals(memberEntity.getEmail())) {
            memberEntity.setEmail(memberEntity.getEmail());
        }

        // 수정된 엔티티 저장
        log.info("변경된 정보 : {}",memberEntity.getMemberId());
        log.info("변경된 정보 : {}",memberEntity.getMemberNickName());
        log.info("변경된 정보 : {}",memberEntity.getMemberNo());
        log.info("변경된 정보 : {}",memberEntity.getEmail());
        log.info("변경된 정보 : {}",memberEntity.getPhone());

        memberRepository.save(memberEntity);

    }
}


