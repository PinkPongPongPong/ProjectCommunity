package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.common.Pagenation;
import com.ohgiraffers.projectgin.common.PagingButtonInfo;
import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.entity.Notification;
import com.ohgiraffers.projectgin.model.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("")
    public String notification(Model model){
        log.info("notification 요청들어옴...");

        List<Notification> notifications = notificationService.getNotificationList();
        model.addAttribute("notifications", notifications);

        return "/admin/notification";
    }

    @GetMapping("/input")
    public ModelAndView Input(ModelAndView mv){
        mv.setViewName("/admin/notificationInput");
        return mv;
    }

    @PostMapping("/input")
    public String notificationContent(@ModelAttribute NotificationDTO newNotification, ModelAndView mv){

        log.info("newNotificationDTO : {}" , newNotification);
        notificationService.savedNotification(newNotification);
        mv.setViewName("redirect:/admin/notification");

        return "/admin/notification";
    }

    @GetMapping("/notification")
    public String findAllNotification(@PageableDefault Pageable pageable, Model model) {

        log.info("pageable = {}", pageable);

        Page<NotificationDTO> notificationList = notificationService.findAllNotification(pageable);

//        log.info("조회한 내용 목록 : {}", notificationList.getContent());
//        log.info("총 페이지 수 : {}", notificationList.getTotalPages());
//        log.info("총 메뉴 수 : {}", notificationList.getTotalElements());
//        log.info("해당 페이지에 표시 될 요소 수 : {}", notificationList.getSize());
//        log.info("해당 페이지에 실제 요소 수 : {}", notificationList.getNumberOfElements());
//        log.info("첫 페이지 여부 : {}", notificationList.isFirst());
//        log.info("마지막 페이지 여부 : {}", notificationList.isLast());
//        log.info("정렬 방식 : {}", notificationList.getSort());
//        log.info("여러 페이지 중 현재 인덱스 : {}", notificationList.getNumber());

        PagingButtonInfo paging = Pagenation.getPagingButtonInfo(notificationList);

        //디버깅로그
        log.info("Paging Button Info : {}", paging);
        log.info("Paging Start Page : {}", paging.getStartPage());

        model.addAttribute("paging", paging);
        model.addAttribute("notificationList", notificationList);

        return "admin/notification";
    }


}
