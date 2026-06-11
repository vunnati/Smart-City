package com.smartCity.webApp.controller;

import com.smartCity.objects.applications.Application;
import com.smartCity.repository.AdminRepository;
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

import java.util.List;

@Data
@Controller
@RequestMapping("/admin")
public class AdminLandingController {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/adminLanding")
    public String adminLanding(Model model) {
        String currentUserName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        if(!currentUserName.isEmpty()){
            List<Application> applications = applicationRepository.findByAdminsAdminID(adminRepository.findByUsername(currentUserName).getAdminID());
            model.addAttribute("applications", applications);
        }
        return "adminLanding";
    }

}
