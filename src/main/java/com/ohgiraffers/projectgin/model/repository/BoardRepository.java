package com.ohgiraffers.projectgin.model.repository;

import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByBoardCategory(BoardCategory boardCategory);
    List<Board> findByTitleContaining(String title);
    List<Board> findByContentContaining(String content);
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
}
