package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Leg {

    @JsonProperty("via_waypoints")
    public List<Object> viaWaypoints;

    @JsonProperty("admins")
    public List<Admin> admins;

    @JsonProperty("weight")
    public Double weight;

    @JsonProperty("duration")
    public Double duration;

    @JsonProperty("steps")
    public List<Step> steps;

    @JsonProperty("distance")
    public Double distance;

    @JsonProperty("summary")
    public String summary;

}
