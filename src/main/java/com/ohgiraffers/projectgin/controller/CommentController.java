package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.CommentDTO;
import com.ohgiraffers.projectgin.model.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {

        return commentService.createComment(commentDTO);
    }

    @GetMapping("/board/{boardNo}")
    public List<CommentDTO> getCommentsByBoardId(@PathVariable int boardNo) {
        return commentService.getCommentsByBoardId(boardNo);
    }

//    @PutMapping("/{commentNo")
//    public CommentDTO updateComment(@PathVariable int commentNo, @RequestBody CommentDTO commentDTO) {
//        return commentService.updateComment(commentNo, commentDTO);
//    }
//
//    @DeleteMapping("/{commentNo}")
//    public void deleteComment(@PathVariable int commentNo) {
//        commentService.deleteComment(commentNo);
//    }

}
