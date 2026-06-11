package com.smartCity.webApp.service.evStation;

import com.smartCity.objects.directions.Directions;
import com.smartCity.objects.evStations.EVStations;
import com.smartCity.objects.steps.Step;
import com.smartCity.objects.steps.Steps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class UriBuilder {

    public EVStations nearestStationURIBuilder(String location, String fuelType, String country, String limit, String radius, String key){
        String url ="https://developer.nrel.gov/api/alt-fuel-stations/v1/nearest.json";
        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("api_key", key)
                .queryParam("location",location)
                .queryParam("fuel_type" ,fuelType)
                .queryParam("country", country)
                .queryParam("radius", radius)
                .queryParam("limit", limit)
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EVStations> responseEntity = restTemplate.getForEntity(uri, EVStations.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle error response here
            return null;
        }
    }

    public Directions directionsAPI(Double startLong, Double startLat, Double endLong, Double endLat, String apiKey){
        String url = "https://api.mapbox.com/directions/v5/mapbox/driving/"+startLong+","+startLat+";"+endLong+","+endLat;
        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("geometries", "geojson")
                .queryParam("access_token", apiKey)
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Directions> responseEntity = restTemplate.getForEntity(uri, Directions.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }

    }

    public Steps stepsAPI(Double startLong, Double startLat, Double endLong, Double endLat, String apiKey){
        String url = "https://api.mapbox.com/directions/v5/mapbox/driving/"+startLong+","+startLat+";"+endLong+","+endLat;
        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("steps", true)
                .queryParam("access_token", apiKey)
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Steps> responseEntity = restTemplate.getForEntity(uri, Steps.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
}
