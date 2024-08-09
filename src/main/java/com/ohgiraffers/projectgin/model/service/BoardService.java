package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.BoardDTO;
import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.BoardCategoryRepository;
import com.ohgiraffers.projectgin.model.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    private final BoardCategoryRepository boardCategoryRepository;


    public void create(BoardDTO boardDTO, MemberEntity memberEntity) {

        Board board = Board.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .member(memberEntity)
                .build();

        Board saveBoard = boardRepository.save(board);

        log.info("저장된 게시글 번호 : {}", saveBoard.getPostNo());
    }

    public Board findBoardById(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));

                return board;
    }


    public List<Board> searchByTitle(String title) {
        return boardRepository.findByTitleContaining(title);
    }

    public List<Board> findByAuthorContaining(String author) {
        return boardRepository.findByTitleContaining(author);
    }
    public List<Board> searchByContent(String content) {
        return boardRepository.findByContentContaining(content);
    }
    public List<Board> searchByTitleOrContent(String keyword) {
        return boardRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }

    public Page<BoardDTO> findAllBoard(Pageable pageable) {
        return null;
    }

//    public Page<BoardDTO> findAllBaord(Pageable pageable) {
//    }
}
