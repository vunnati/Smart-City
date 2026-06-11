package com.smartCity.webApp.controller;

import com.smartCity.objects.users.UserHistory;
import com.smartCity.repository.UserHistoryRepository;
import com.smartCity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class HistoryController {

    @Autowired
    UserHistoryRepository userHistoryRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/history")
    public String getHistory(Model model){

        List<UserHistory> history = new ArrayList<>();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName();

            for (UserHistory userHistory : userHistoryRepository.findAll()) {
                if (userHistory.getUser().getUsername().equalsIgnoreCase(userName)) {
                    history.add(userHistory);
                }
            }
        }

        model.addAttribute("history", history);

        return "history";
    }

}
