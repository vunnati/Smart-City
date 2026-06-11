package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Waypoint {

    @JsonProperty("distance")
    public Double distance;

    @JsonProperty("name")
    public String name;

    @JsonProperty("location")
    public List<Double> location;

}
