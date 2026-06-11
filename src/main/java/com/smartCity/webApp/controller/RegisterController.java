package com.smartCity.webApp.controller;

import com.smartCity.objects.users.Account;
import com.smartCity.repository.AccountRepository;
import com.smartCity.webApp.service.login.RegisterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Data
@Controller
public class RegisterController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RegisterService registerService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String login(Model model) {
        return "register";
    }

    @PostMapping("/addUser")
    public String addUser(Model model, @ModelAttribute Account account){
        if (registerService.checkUserName(account)) {
            model.addAttribute("error", "Username already in use");
        }else{
            String encodedPwd = passwordEncoder.encode(account.getPassword());
            account.setPassword(encodedPwd);
            registerService.addToUserOrAdminTable(account);
            accountRepository.save(account);
        }
        return "register";
    }

}
