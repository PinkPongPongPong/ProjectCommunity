package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/notification")
    public ModelAndView notice(ModelAndView mv) {

        List<NotificationDTO> notificationList = new ArrayList<>();
        notificationList.add(new NotificationDTO("1", "2", "제목", "내용","2024-01-01","3"));
        notificationList.add(new NotificationDTO("2", "3", "제목1", "내용1","2024-01-02","4"));
//        notificationList.add(new NotificationDTO("1", "2", "제목", "내용","2024-01-01","3"));
//        notificationList.add(new NotificationDTO("1", "2", "제목", "내용","2024-01-01","3"));

        mv.addObject("notificationList", notificationList);
        mv.setViewName("/admin/notification");

//        List<NotificationDTO> notificationList = notificationService.create();
        return mv;
    }

    @PostMapping("/notification")
    public String registNewMenu(@ModelAttribute NotificationDTO newNotification) {

//        notificationService.create();

        return "redirect:/admin/notification";
    }

}
