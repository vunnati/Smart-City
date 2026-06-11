package com.smartCity.webApp.controller;

import com.smartCity.objects.message.UserMessages;
import com.smartCity.repository.UserMessageRepository;
import com.smartCity.webApp.service.messages.AdminMessagesService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@RequestMapping("/admin")
public class AdminMessagesController {

    @Autowired
    UserMessageRepository userRepository;

    @Autowired
    AdminMessagesService adminMessagesService;

    @GetMapping("/messages")
    public String messages(Model model){

        List<UserMessages> messages = userRepository.findAll();
        List<UserMessages> reservation = new ArrayList<>();
        List<UserMessages> pricing = new ArrayList<>();
        List<UserMessages> status = new ArrayList<>();
        for (UserMessages message : messages) {

            if (message.getTopic().equalsIgnoreCase("Reserve") && !message.getProcessed()) {
                reservation.add(message);
            } else if (message.getTopic().equalsIgnoreCase("Price") && !message.getProcessed()) {
                pricing.add(message);
            } else if (message.getTopic().equalsIgnoreCase("Status") && !message.getProcessed()) {
                status.add(message);
            }
        }

        model.addAttribute("reserve", reservation);
        model.addAttribute("pricing", pricing);
        model.addAttribute("status", status);

        return "adminMessages";
    }

    @PostMapping("/messages/reservation")
    public String processReservation(@RequestParam("messageID") Integer messageID, Model model){
        adminMessagesService.reserveStation(messageID);
        return "redirect:adminMessages";
    }

    @PostMapping("/messages/pricing")
    public String processPricing(@RequestParam("messageID") Integer messageID, Model model){
        adminMessagesService.pricingInformation(messageID);
        return "redirect:adminMessages";
    }

    @PostMapping("/messages/status")
    public String processStatus(@RequestParam("messageID") Integer messageID, Model model){
        adminMessagesService.statusInformation(messageID);
        return "redirect:adminMessages";
    }
}
