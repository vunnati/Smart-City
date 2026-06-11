package com.smartCity.webApp.controller;

import com.smartCity.objects.applications.Application;
import com.smartCity.objects.applications.ApplicationChoices;
import com.smartCity.repository.ApplicationChoiceRepository;
import com.smartCity.repository.ApplicationRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@Controller
@RequestMapping("/admin")
public class CustomizeApplicationController {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    ApplicationChoiceRepository applicationChoiceRepository;

    Integer appID;

    @PostMapping("/customizeApp")
    public String customizeApp(@RequestParam("applicationId") Integer id, Model model) {
        appID = id;
        Application app = applicationRepository.findByApplicationID(id);
        applicationRepository.updateCustomizedStatusToTrue(id);
        model.addAttribute("applicationType", app.getApplicationType());
        return "applicationCustomization";
    }

    @PostMapping("/customizeApp/appChoices")
    public String appChoices(Model model, @ModelAttribute ApplicationChoices applicationChoices){
        applicationChoices.setApplication(applicationRepository.findByApplicationID(appID));
        applicationChoices.setApplicationType(applicationRepository.findByApplicationID(appID).getApplicationType());
        applicationChoiceRepository.save(applicationChoices);
        model.addAttribute("success", "Application Successfully customized");
        return "redirect:/admin/adminLanding";
    }
}
