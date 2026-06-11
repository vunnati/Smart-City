package com.smartCity.webApp.service.evStation;

import com.smartCity.objects.directions.Directions;
import com.smartCity.objects.evStations.EVStations;
import com.smartCity.objects.evStations.FuelStation;
import com.smartCity.objects.steps.Steps;
import com.smartCity.objects.users.UserHistory;
import com.smartCity.repository.UserHistoryRepository;
import com.smartCity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EVStationService {

    @Autowired
    UriBuilder uriBuilder;

    @Autowired
    UserHistoryRepository userHistoryRepository;

    @Autowired
    UserRepository userRepository;

    public Directions getGeometries(String stationID, EVStations evStations, String mapboxApiKey) {

        FuelStation end = new FuelStation();
        for(int i = 0; i < evStations.getFuelStations().size(); i++){
            if(evStations.getFuelStations().get(i).getId() == Integer.parseInt(stationID)){
                end = evStations.getFuelStations().get(i);
            }
        }

        Double startLong = evStations.getLongitude();
        Double startLat = evStations.getLatitude();

        Double endLong = end.getLongitude();
        Double endLat = end.getLatitude();

        return uriBuilder.directionsAPI(startLong, startLat, endLong, endLat, mapboxApiKey);
    }

    public Steps getSteps(String stationID, EVStations evStations, String mapboxApiKey){
        FuelStation end = new FuelStation();
        for(int i = 0; i < evStations.getFuelStations().size(); i++){
            if(evStations.getFuelStations().get(i).getId() == Integer.parseInt(stationID)){
                end = evStations.getFuelStations().get(i);
            }
        }

        Double startLong = evStations.getLongitude();
        Double startLat = evStations.getLatitude();

        Double endLong = end.getLongitude();
        Double endLat = end.getLatitude();

        return uriBuilder.stepsAPI(startLong, startLat, endLong, endLat, mapboxApiKey);
    }

    public void addToHistory(String stationID, String action, List<FuelStation> stations) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = "";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }

        boolean matching = false;

        if (userHistoryRepository.findAll().isEmpty()) {
            UserHistory history = new UserHistory();
            history.setEvStationID(Integer.valueOf(stationID));
            for (FuelStation station : stations) {
                if (Objects.equals(station.getId(), Integer.valueOf(stationID))) {
                    history.setEvStationAddress(station.getStreetAddress());
                    history.setTimesUsed(1);
                    history.setAction(action);
                    history.setUser(userRepository.findByUsername(userName));
                }
            }
            userHistoryRepository.save(history); // Save the new history
        } else {
            List<UserHistory> userHistories = userHistoryRepository.findAll();

            for (UserHistory history : userHistories) {
                if (Objects.equals(history.getEvStationID(), Integer.valueOf(stationID)) &&
                        Objects.equals(history.getUser(), userRepository.findByUsername(userName))) {
                    matching = true;
                    Integer timesUsed = history.getTimesUsed() + 1;
                    userHistoryRepository.updateTimesUsedByHistoryID(timesUsed, history.getHistoryID());
                }
            }

            if (!matching) {
                UserHistory history = new UserHistory();
                history.setEvStationID(Integer.valueOf(stationID));
                for (FuelStation station : stations) {
                    if (Objects.equals(station.getId(), Integer.valueOf(stationID))) {
                        history.setEvStationAddress(station.getStreetAddress());
                        history.setTimesUsed(1);
                        history.setAction(action);
                        history.setUser(userRepository.findByUsername(userName));
                    }
                }
                userHistoryRepository.save(history); // Save the new history
            }
        }
    }

}
