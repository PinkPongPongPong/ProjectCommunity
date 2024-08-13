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
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    private final BoardCategoryRepository boardCategoryRepository;


    public List<BoardDTO> findAllByCategory(String category) {
        List<Board> boards = boardRepository.findAllByBoardCategory(boardCategoryRepository.findByBoardCategory(category));
        return boards.stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());
    }

    public List<BoardDTO> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());
    }

    public BoardDTO getBoardById(int id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        return modelMapper.map(board, BoardDTO.class);
    }

    public BoardDTO create(BoardDTO boardDTO, MemberEntity memberEntity) {
        Board board = modelMapper.map(boardDTO, Board.class);
        board = boardRepository.save(board);
        return modelMapper.map(board, BoardDTO.class);
    }

//    public void create(BoardDTO boardDTO, MemberEntity memberEntity) {
//
//        Board board = Board.builder()
//                .title(boardDTO.getTitle())
//                .content(boardDTO.getContent())
//                .member(memberEntity)
//                .build();
//
//        Board saveBoard = boardRepository.save(board);
//
//        log.info("저장된 게시글 번호 : {}", saveBoard.getPostNo());
//    }

    public Board findBoardById(int boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));

                return board;
    }


    public List<Board> searchByTitle(String keyword) {
        return boardRepository.findByTitleContaining(keyword);
    }


    public List<Board> searchByAuthor(String keyword) {
        return boardRepository.findByAuthorContaining(keyword);
    }

    public List<Board> searchByContent(String keyword) {
        return boardRepository.findByContentContaining(keyword);
    }

    public List<Board> searchByTitleOrContent(String title,String content) {
        return boardRepository.findByTitleContainingOrContentContaining(title, content);
    }

    public Page<BoardDTO> findAllBoard(Pageable pageable) {
        return null;
    }

    public List<BoardDTO> findByCategory(String category) {
        List<Board> boards = boardRepository.findByCategory(category);
        return boards.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
    }

    public BoardDTO findById(int id) {
        Board board = boardRepository.findById(id).orElse(null);
        return modelMapper.map(board, BoardDTO.class);
    }

    public void save(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        boardRepository.save(board);
    }

    public void delete(int id) {
        boardRepository.deleteById(id);
    }
}


