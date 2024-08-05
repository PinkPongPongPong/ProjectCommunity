package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.UserSignupDTO;
import com.ohgiraffers.projectgin.model.entity.RoleType;
import com.ohgiraffers.projectgin.model.entity.UserEntity;
import com.ohgiraffers.projectgin.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(UserSignupDTO signupDTO) {
        UserEntity user = UserEntity.builder()
                .userId(signupDTO.getUserId())
                .password(passwordEncoder.encode(signupDTO.getPassword())) // 암호화
                .name(signupDTO.getName())
                .role(RoleType.valueOf(signupDTO.getRole())) // user.admin
                .build();
        UserEntity savedUser = userRepository.save(user);
        log.info("저장된 회원 정보 : {}", savedUser.getUserNo());
    }
}

