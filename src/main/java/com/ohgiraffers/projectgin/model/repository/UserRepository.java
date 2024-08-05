package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findUserEntitiesByUserId(String userId);
}