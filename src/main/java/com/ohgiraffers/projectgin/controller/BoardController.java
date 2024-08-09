package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.common.Pagenation;
import com.ohgiraffers.projectgin.common.PagingButtonInfo;
import com.ohgiraffers.projectgin.model.dto.BoardDTO;
import com.ohgiraffers.projectgin.model.dto.MemberSignupDTO;
import com.ohgiraffers.projectgin.model.entity.Board;
import com.ohgiraffers.projectgin.model.entity.MemberEntity;
import com.ohgiraffers.projectgin.model.repository.BoardRepository;
import com.ohgiraffers.projectgin.model.service.BoardService;
import com.ohgiraffers.projectgin.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.NoSuchFileException;
import java.util.List;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Autowired
    private final BoardService boardService;
    private final MemberService memberService;
    private final BoardRepository boardRepository;

    public BoardController(MemberService memberService, BoardService boardService, BoardRepository boardRepository) {
        this.memberService = memberService;
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/create")
    public void createBoard() {

    }

    @PostMapping("/create")
    public String postBoard(@AuthenticationPrincipal UserDetails userDetails, BoardDTO boardDTO) throws NoSuchFileException {

        String memberId = userDetails.getUsername();

        MemberEntity memberEntity = memberService.findMemberById(memberId);
        log.info("로그인한 사용자 ID :", memberId);
        log.info("전달받은 BoardDTO : {} :",boardDTO);

        boardService.create(boardDTO, memberEntity);
        return "/page/post/strategypage";
    }

    @GetMapping("/{boardId}")
    public String getBoardDetail(@PathVariable int boardId, Model model) {
        Board board = boardService.findBoardById(boardId);

        model.addAttribute("board",board);

        return "post/detail";
    }
    @GetMapping("/search")
    public String searchByTitle(@RequestParam("keyword") String title, Model model) {
        List<Board> results = boardService.searchByTitle(title);
        model.addAttribute("result", results);
        return "searchResults";
    }



    @GetMapping("/search")
    public String searchByAuthor(@RequestParam("keyword") String keyword, Model model) {
        List<Board> results = boardService.searchByTitleOrContent(keyword);
        model.addAttribute("result", results);
        return "searchResults"; // 템플릿 이름
    }

    @GetMapping("/search")
    public String searchByContent(@RequestParam("keyword") String keyword, Model model) {
        List<Board> results = boardService.searchByTitleOrContent(keyword);
        model.addAttribute("result", results);
        return "searchResults"; // 템플릿 이름
    }

    @GetMapping("/search")
    public String searchByTitleOrContent(@RequestParam("keyword") String keyword, Model model) {
        List<Board> results = boardService.searchByTitleOrContent(keyword);
        model.addAttribute("result", results);
        return "searchResults"; // 템플릿 이름
    }

    @GetMapping("/list")
    public String findAllTable(@PageableDefault Pageable pageable, Model model) {

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

        return "page/post/list";

    }
}
