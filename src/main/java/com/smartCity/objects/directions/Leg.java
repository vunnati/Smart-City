package com.smartCity.objects.directions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    public List<Object> steps;

    @JsonProperty("distance")
    public Double distance;

    @JsonProperty("summary")
    public String summary;

}
