package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.common.Pagenation;
import com.ohgiraffers.projectgin.common.PagingButtonInfo;
import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("")
    public String notification(@PageableDefault Pageable pageable, Model model){
        log.info("notification 요청들어옴...");

        Page<NotificationDTO> notifications = notificationService.findAllnotification(pageable);

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(notifications);

//       log.info("paging : {}", paging);

        model.addAttribute("paging", paging);
        model.addAttribute("notifications", notifications);

        return "admin/notification";
    }

    @GetMapping("/input")
    public ModelAndView Input(ModelAndView mv){
        mv.setViewName("admin/notificationInput");
        return mv;
    }

    @PostMapping("/input")
    public ModelAndView notificationContent(@ModelAttribute NotificationDTO newNotification, ModelAndView mv){

        log.info("newNotificationDTO : {}" , newNotification);
        notificationService.savedNotification(newNotification);
        mv.setViewName("redirect:/notification");

        return mv;
    }

    // 단일 조회 기능
    @GetMapping("/{notificationNo}")
    public String findMenuByCode(@PathVariable("notificationNo") int notificationNo, Model model) {

        log.info("notification : {}", notificationNo);
        NotificationDTO notification = notificationService.findNotificationByCode(notificationNo);
        model.addAttribute("notification", notification);

        return "/admin/detail";
    }

//    @GetMapping("/notificationmodify/{notificaitonNo}")
//    public String modifyPage(@PathVariable int notificationNo, Model model) {
//
//        log.info("menuCode = {}", notificationNo);
//
//        // 메뉴코드로 메뉴 조회해오는 기능
//        NotificationDTO notification = notificationService.findMenuByCode(notificationNo);
//
//        model.addAttribute("notification", notification);
//
//        return "admin/notificationmodify";
//    }
//
//
//    @PostMapping("/notificationmodify")
//    // ModelAttribute 생략가능
//    public String modifyMenu(NotificationDTO modifyNotification) {
//
//        log.info("modifyMenu =========== {}", modifyNotification);
//
//        notificationService.modifyNotification(modifyNotification);
//
//        return "redirect:/notification/modify/" + modifyNotification.getNotificationNo();
//    }



}
