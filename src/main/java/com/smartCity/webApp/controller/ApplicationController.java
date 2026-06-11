package com.smartCity.webApp.controller;
import com.smartCity.objects.applications.Application;
import com.smartCity.repository.AdminRepository;
import com.smartCity.repository.ApplicationRepository;
import com.smartCity.webApp.service.application.ApplicationService;
import com.smartCity.webApp.service.application.FileSystemStorageService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Data
@Controller
@RequestMapping("/admin")
public class ApplicationController {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    FileSystemStorageService storageService;

    @Autowired
    ApplicationService applicationService;

    @Value("${project.images}")
    private String path;

    @GetMapping("/application")
    public String adminLanding(Model model) {
        return "addApplication";
    }


    @PostMapping(value = "/newapplication", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String addApplication(Model model, @ModelAttribute("application") Application application, @RequestParam(value = "imageFile",required = false) MultipartFile file) throws IOException {

        application = applicationService.createPayload(application,file.getOriginalFilename());
        applicationRepository.save(application);
        storageService.store(file);

        List<Application> applications = applicationRepository.findByAdminsAdminID(application.getAdmins().getAdminID());
        model.addAttribute("applications", applications);
        model.addAttribute("imageName", application.getImageName());
        return "addApplication";

    }

}
