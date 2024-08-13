package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.BoardDTO;
import com.ohgiraffers.projectgin.model.dto.CommentDTO;
import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.Comment;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        Comment savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDTO.class);
    }

    public List<CommentDTO> getCommentsByBoardId(int boardNo) {
        List<Comment> comments = commentRepository.findAll().stream()
                .filter(comment -> comment.getBoard().getPostNo() == boardNo)
                .collect(Collectors.toList());
        return comments.stream().map(comment -> modelMapper.map(comment,CommentDTO.class)).collect(Collectors.toList());
    }

    public CommentDTO updateComment(int commentNo, CommentDTO commentDTO) {
        Comment existingComment = commentRepository.findById(commentNo)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        existingComment.(commentDTO.getComment());

    }


    public void deleteComment(int commentNo) {

    }
}
