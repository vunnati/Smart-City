package com.smartCity.webApp.service.messages;

import com.smartCity.config.mqtt.MqttGateway;
import com.smartCity.objects.evStations.Reservations;
import java.util.Random;
import com.smartCity.objects.message.UserMessages;
import com.smartCity.objects.users.User;
import com.smartCity.repository.AdminMessageRepository;
import com.smartCity.repository.ReservationRepository;
import com.smartCity.repository.UserMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AdminMessagesService {

    @Autowired
    MqttGateway mqttGateway;

    @Autowired
    UserMessageRepository userMessageRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    AdminMessageRepository adminMessageRepository;

    public void reserveStation(Integer messageID) {

        UserMessages reservationInfo = userMessageRepository.findByMessageID(messageID);

        //MQTT message
        String topic = "completed reservation";
        String message = "Spot at EV Station number "+reservationInfo.getMessage()+" successfully reserved";
        String userName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        message = message +","+userName;

        User user = reservationInfo.getUser();

        message = message + ","+user.getUserID();

        //Processing message
        userMessageRepository.markAsProcessed(true, messageID);

        //Reservation creation

        Reservations reservations = new Reservations();

        reservations.setUser(reservationInfo.getUser());
        reservations.setEvStaionID(Integer.valueOf(reservationInfo.getMessage()));

        reservationRepository.save(reservations);

        mqttGateway.senToMqtt(message, topic);
    }

    public void pricingInformation(Integer messageID) {

        //MQTT message
        double minPricePerMinute = 0.15;
        double maxPricePerMinute = 0.35;
        double randomPricePerMinute = generateRandomPrice(minPricePerMinute, maxPricePerMinute);
        UserMessages userMessages = userMessageRepository.findByMessageID(messageID);

        String topic = "Pricing information";
        String message = "Price at station number " + userMessages.getMessage() + " is: $" + String.format("%.2f", randomPricePerMinute)+" dollars per minute";
        String userName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        User user = userMessageRepository.findByMessageID(messageID).getUser();
        message = message + "," + userName + ","+user.getUserID();

        userMessageRepository.markAsProcessed(true, messageID);

        mqttGateway.senToMqtt(message, topic);

    }

    public void statusInformation(Integer messageID) {

        //MQTT message

        String topic = "Status information";
        UserMessages userMessages = userMessageRepository.findByMessageID(messageID);

        int availablePumps = generateRandomPumps(0, 8);
        String message = availablePumps + "/8 are in use for EV Station with ID: "+userMessages.getMessage();
        String userName = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        User user = userMessageRepository.findByMessageID(messageID).getUser();
        message = message + "," + userName + ","+user.getUserID();
        message = message + "," + userName;

        userMessageRepository.markAsProcessed(true, messageID);

        mqttGateway.senToMqtt(message, topic);

    }

    private static double generateRandomPrice(double min, double max) {
        Random rand = new Random();
        return min + (max - min) * rand.nextDouble();
    }

    private static int generateRandomPumps(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

}
