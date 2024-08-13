package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    // 제목으로 검색
    List<Board> findByTitleContaining(String title);
    // 작성자로 검색
    List<Board> findByAuthorContaining(String author);
    // 내용으로 검색
    List<Board> findByContentContaining(String content);
    // 제목 또는 내용으로 검색
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
    List<Board> findByCategory(String category);
    List<Board> findAllByBoardCategory(BoardCategory boardCategory);
}
