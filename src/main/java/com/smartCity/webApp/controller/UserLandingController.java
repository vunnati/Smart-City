package com.smartCity.webApp.controller;
import com.smartCity.objects.message.AdminMessages;
import com.smartCity.objects.message.UserMessages;
import com.smartCity.repository.AdminMessageRepository;
import com.smartCity.repository.ApplicationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.smartCity.objects.applications.Application;

import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@RequestMapping("/user")
public class UserLandingController {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    AdminMessageRepository adminMessageRepository;

    @GetMapping("/userLanding")
    public String userLanding(Model model) {

        List<Application> applications = applicationRepository.findAll();
        model.addAttribute("applications", applications);

        String userName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        List<AdminMessages> allMessages = adminMessageRepository.findAll();
        List<AdminMessages> notifications = new ArrayList<>();

        for (AdminMessages allMessage : allMessages) {
            if (allMessage.getUser().getUsername().equalsIgnoreCase(userName)) {
                notifications.add(allMessage);
            }
        }
        model.addAttribute("notification", notifications);
        return "userLanding";
    }

    @GetMapping("/Applications")
    public String applicationNav(Model model) {
        return "ApplicationsUser";
    }

    @GetMapping("OurGoal")
    public String ourGoals(Model model){ return "ourGoals";}

    @GetMapping("OurTeam")
    public String ourTeams(Model model){ return "ourTeams";}

    @GetMapping("Reviews")
    public String reviews(Model model){ return "reviews";}

}
