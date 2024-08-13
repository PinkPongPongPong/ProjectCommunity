package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    Optional<MemberEntity> findMemberEntityByMemberId(String memberId);
}