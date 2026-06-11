package com.smartCity.webApp.controller;

import com.smartCity.objects.users.Account;
import com.smartCity.webApp.service.login.LoginService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
@Controller
public class LoginController {

    @Autowired
    LoginService loginService = new LoginService();

    @ModelAttribute("account")
    public Account getSessionUser(){
        return new Account();
    }

    @GetMapping("/")
    public String submit(Model model)
    {
        return "index";
    }

    @GetMapping("/index")
    public String login(Model model) {
        return "index";
    }

    @GetMapping("/logout")
    public String logout() {
        SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
        return "/index";
    }
}
