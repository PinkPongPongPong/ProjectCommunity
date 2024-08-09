package com.ohgiraffers.projectgin.controller;

import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.entity.Notification;
import com.ohgiraffers.projectgin.model.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

}
