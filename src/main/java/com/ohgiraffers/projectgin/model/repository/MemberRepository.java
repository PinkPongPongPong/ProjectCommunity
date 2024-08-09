package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findMemberEntityByMemberId(String memberId);
    boolean existsByMemberId(String userId);

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    boolean existsByName(String name);

    boolean existsByMemberNickName(String memberNickName);
}