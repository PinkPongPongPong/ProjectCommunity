package com.ohgiraffers.projectgin.auth.service;


import com.ohgiraffers.projectgin.auth.principal.AuthPrincipal;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity memberEntity =  userRepository
                .findMemberEntityByMemberId(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        log.info("로그인하는 회원이름 : {}", memberEntity.getMemberNickName());
        return new AuthPrincipal(memberEntity);
    }
}
