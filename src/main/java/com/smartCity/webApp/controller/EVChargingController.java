package com.smartCity.webApp.controller;

import com.smartCity.config.mqtt.MqttGateway;
import com.smartCity.objects.applications.Application;
import com.smartCity.objects.applications.ApplicationChoices;
import com.smartCity.objects.directions.Directions;
import com.smartCity.objects.evStations.EVStations;
import com.smartCity.objects.evStations.FuelStation;
import com.smartCity.objects.steps.Steps;
import com.smartCity.repository.ApplicationChoiceRepository;
import com.smartCity.webApp.service.evStation.EVStationService;
import com.smartCity.webApp.service.evStation.UriBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@Controller
@RequestMapping("/user")
public class EVChargingController {

    EVStations evStations;

    @Value("${api.nrel}")
    public String nrelApiKey;

    @Value("${api.mapbox}")
    public String mapboxApiKey;

    @Autowired
    UriBuilder uriBuilder;

    @Autowired
    EVStationService evStationService;

    @Autowired
    ApplicationChoiceRepository applicationChoiceRepository;

    @Autowired
    MqttGateway mqttGateway;

    List<FuelStation> fuelStations;

    @PostMapping("/evcharging")
    public String evCharging(@RequestParam("applicationId") Integer appID, Model model) {

        boolean mapEmbed = false;
        boolean textDir = false;
        boolean search = false;
        boolean nrel = false;

        if(applicationChoiceRepository.findByApplicationApplicationID(appID) != null){
            ApplicationChoices applicationChoices = applicationChoiceRepository.findByApplicationApplicationID(appID);
            for(int i = 0; i < applicationChoices.getElements().size(); i++){
                if(applicationChoices.getElements().get(i).equals("EmbeddedMap")){
                    mapEmbed = true;
                    model.addAttribute("mapEmbed", mapEmbed);
                }
                if(applicationChoices.getElements().get(i).equals("TextDirections")){
                    textDir = true;
                    model.addAttribute("textDir", textDir);
                }
                if(applicationChoices.getElements().get(i).equals("CustomSearchBar")){
                    search = true;
                    model.addAttribute("search", search);
                }
                if(applicationChoices.getElements().get(i).equals("UseNRELEmbed")){
                    nrel = true;
                    model.addAttribute("nrel", nrel);
                }
            }
        }

        return "evcharging";
    }

    @PostMapping("/evcharging/locator")
    public String locator(Model model, String location) {

        String fuelType = "ELEC";
        String country = "CA";
        String limit = "5";
        String radius = "5";

        evStations = uriBuilder.nearestStationURIBuilder(location, fuelType, country, limit, radius, nrelApiKey);
        model.addAttribute("evStations", evStations.getFuelStations());
        fuelStations = evStations.getFuelStations();
        return "evcharging";
    }

    @PostMapping("/evcharging/routing/{evStationID}")
    public String routing(Model model, @PathVariable("evStationID") String stationID){


        Directions directions = evStationService.getGeometries(stationID, evStations, mapboxApiKey);
        Steps steps = evStationService.getSteps(stationID, evStations, mapboxApiKey);
        evStationService.addToHistory(stationID, "Routing", fuelStations );

        model.addAttribute("steps", steps.getRoutes().get(0).getLegs().get(0).getSteps());
        model.addAttribute("directions", directions);
        model.addAttribute("evStations", null);


        return "evcharging";
    }

    @PostMapping("/evcharging/reserve/{evStationID}")
    public String reserve(Model model, @PathVariable("evStationID") String stationID){

        evStationService.addToHistory(stationID, "Reservation inquiry", fuelStations );

        String topic = "reserve";
        String userName = "";

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        mqttGateway.senToMqtt(stationID+","+userName, topic);

        return "evcharging";
    }

    @PostMapping("/evcharging/price/{evStationID}")
    public String price(Model model, @PathVariable("evStationID") String stationID){

        evStationService.addToHistory(stationID, "Pricing inquiry", fuelStations );
        String userName = "";

        String topic = "price";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        mqttGateway.senToMqtt(stationID+","+userName, topic);

        return "evcharging";
    }

    @PostMapping("/evcharging/status/{evStationID}")
    public String status(Model model, @PathVariable("evStationID") String stationID){

        evStationService.addToHistory(stationID, "Status inquiry", fuelStations );

        String userName = "";
        String topic = "status";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        mqttGateway.senToMqtt(stationID+","+userName, topic);

        return "evcharging";
    }
}
