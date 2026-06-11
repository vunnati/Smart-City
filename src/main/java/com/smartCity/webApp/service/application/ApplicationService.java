package com.smartCity.webApp.service.application;

import com.smartCity.objects.applications.Application;
import com.smartCity.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService{
    @Autowired
    AdminRepository adminRepository;

    public Application createPayload(Application application, String imageName) {
        String currentUserName = "";
        application.setImageName(imageName);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        application.setAdmins(adminRepository.findByUsername(currentUserName));
        application.setCustomized(false);
        return application;
    }
}
