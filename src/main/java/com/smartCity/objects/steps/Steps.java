package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Steps {

    @JsonProperty("routes")
    public List<Route> routes;

    @JsonProperty("waypoints")
    public List<Waypoint> waypoints;

    @JsonProperty("code")
    public String code;

    @JsonProperty("uuid")
    public String uuid;
}

