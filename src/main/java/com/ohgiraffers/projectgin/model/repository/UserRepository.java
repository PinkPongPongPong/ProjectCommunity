package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserEntityByUserId(String userId);
}