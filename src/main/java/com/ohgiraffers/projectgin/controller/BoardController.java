package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.common.Pagenation;
import com.ohgiraffers.projectgin.common.PagingButtonInfo;
import com.ohgiraffers.projectgin.model.dto.BoardDTO;
import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.BoardRepository;
import com.ohgiraffers.projectgin.model.repository.CommentRepository;
import com.ohgiraffers.projectgin.model.service.BoardService;
import com.ohgiraffers.projectgin.model.service.CommentService;
import com.ohgiraffers.projectgin.model.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api/boards")
@Slf4j
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;
    private final CommentService commentService;
    private final MemberService memberService;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;


    @GetMapping("/create/board")
    public void createComment() {

    }

    @GetMapping("/strategy")
    public String getStrategyBoard(Model model) {
        List<String> categories = Arrays.asList("battlegrounds", "callofduty", "csonline");
        model.addAttribute("categories", categories);
        return "strategyboard";
    }
    @GetMapping("/{category}/post/{id}")
    public String viewPost(@PathVariable String category, @PathVariable int id, Model model) {
        BoardDTO board = boardService.findById(id);
        model.addAttribute("board", board);
        model.addAttribute("category", category);
        return "board/view";
    }


    @GetMapping("/board/{category}")
    public String getBoardByCategory(@PathVariable String category, Model model) {
        model.addAttribute("boards", boardService.findByCategory(category));
        return "board/board";
    }

    @GetMapping("/board/{category}/post/{id}")
    public String getPostById(@PathVariable String category, @PathVariable int id, Model model) {
        model.addAttribute("post", boardService.findById(id));
        return "board/  ";
    }

    @PostMapping("/board/{category}/post")
    public String createPost(@PathVariable String category, @ModelAttribute BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return "redirect:/board/" + category;
    }

    @DeleteMapping("/board/{category}/post/{id}")
    public String deletePost(@PathVariable String category, @PathVariable int id) {
        boardService.delete(id);
        return "redirect:/board/" + category;
    }


    @PostMapping("/create/board")
    public String postBoard(@AuthenticationPrincipal UserDetails userDetails, BoardDTO boardDTO) throws NoSuchFileException {

        String memberId = userDetails.getUsername();

        MemberEntity memberEntity = memberService.findMemberById(memberId);
        log.info("로그인한 사용자 ID :", memberId);
        log.info("전달받은 BoardDTO : {} :",boardDTO);

        boardService.create(boardDTO, memberEntity);
        return "redirect:/post/strategyregist";
    }

//    @GetMapping("/{boardId}")
//    public String getBoardDetail(@PathVariable int boardId, Model model) {
//        Board board = boardService.findBoardById(boardId);
//
//        model.addAttribute("board",board);
//
//        return "redirect:post/detail";
//    }

    @GetMapping("/search")
    public String searchByTitle(@RequestParam("keyword") String keyword, Model model) {
        List<Board> results = boardService.searchByTitle(keyword);
        model.addAttribute("result", results);
        return "redirect:/post/searchresults";
    }



    @GetMapping("/search")
    public String searchByAuthor(@RequestParam("keyword") String keyword, Model model) {
        List<Board> results = boardService.searchByContent(keyword);
        model.addAttribute("result", results);
        return "redirect:/post/searchresults"; // 템플릿 이름
    }

    @GetMapping("/search")
    public String searchByContent(@RequestParam("keyword") String keyword, Model model) {
        List<Board> results = boardService.searchByContent(keyword);
        model.addAttribute("result", results);
        return "redirect:/post/searchresults"; // 템플릿 이름
    }

    @GetMapping("/search")
    public String searchByTitleOrContent(@RequestParam("titleOrContent") String keyword, Model model) {
        List<Board> results = boardService.searchByTitleOrContent(keyword,keyword);
        model.addAttribute("result", results);
        return "redirect:/post/searchresults"; // 템플릿 이름
    }

    @GetMapping("/list")
    public String findAllTable(@PageableDefault(sort = "postDate", direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        log.info("pageable = {}", pageable);
        Page<BoardDTO> boardList = boardService.findAllBoard(pageable);

        log.info("조회한 내용 목록 : {}", boardList.getContent());
        log.info("총 페이지 수 : {}",  boardList.getTotalPages());
        log.info("총 메뉴 수 : {}", boardList.getTotalElements());
        log.info("해당 페이지에 표시 될 요소 수 : {}", boardList.getSize());
        log.info("해당 페이지에 실제 요소 수 : {}", boardList.getNumberOfElements());
        log.info("첫 페이지 여부 : {}", boardList.isFirst());
        log.info("마지막 페이지 여부 : {}", boardList.isLast());
        log.info("정렬 방식 : {}", boardList.getSort());
        log.info("여러 페이지 중 현재 인덱스 : {}", boardList.getNumber());

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(boardList);

        model.addAttribute("paging", paging);
        model.addAttribute("boardList", boardList);

        return "redirect:/post/boardlist";

    }
}



