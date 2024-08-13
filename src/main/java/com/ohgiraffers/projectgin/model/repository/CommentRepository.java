package com.ohgiraffers.projectgin.model.repository;


import com.ohgiraffers.projectgin.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
