package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.BoardDTO;
import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.BoardCategory;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.BoardCategoryRepository;
import com.ohgiraffers.projectgin.model.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    private final BoardCategoryRepository boardCategoryRepository;

    public List<BoardDTO> findByCategory(String category) {
        BoardCategory boardCategory = boardCategoryRepository.findByBoardCategory(category);
        if (boardCategory == null) {
            throw new IllegalArgumentException("BoardCategory not found for category: " + category);
        }
        List<Board> boards = boardRepository.findByBoardCategory(boardCategory);
        return boards.stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toList());
    }

    public BoardDTO findById(int id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Board not found for ID: " + id));
        return modelMapper.map(board, BoardDTO.class);
    }

    public BoardDTO create(BoardDTO boardDTO, MemberEntity memberEntity) {
        Board board = modelMapper.map(boardDTO, Board.class);
        board.setMember(memberEntity);
        board = boardRepository.save(board);
        return modelMapper.map(board, BoardDTO.class);
    }

    public void save(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        boardRepository.save(board);
    }

    public void delete(int id) {
        if (!boardRepository.existsById(id)) {
            throw new IllegalArgumentException("Board with ID " + id + " does not exist");
        }
        boardRepository.deleteById(id);
    }

    public Page<BoardDTO> findAllBoard(Pageable pageable) {
        return boardRepository.findAll(pageable)
                .map(board -> modelMapper.map(board, BoardDTO.class));
    }

    public List<Board> searchByTitle(String keyword) {
        return boardRepository.findByTitleContaining(keyword);
    }

    public List<Board> searchByContent(String keyword) {
        return boardRepository.findByContentContaining(keyword);
    }

    public List<Board> searchByTitleOrContent(String title, String content) {
        return boardRepository.findByTitleContainingOrContentContaining(title, content);
    }



}


