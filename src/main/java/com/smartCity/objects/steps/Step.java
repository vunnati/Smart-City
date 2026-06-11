package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Step {

    @JsonProperty("intersections")
    public List<Intersection> intersections;

    @JsonProperty("maneuver")
    public Maneuver maneuver;

    @JsonProperty("name")
    public String name;

    @JsonProperty("duration")
    public Integer duration;

    @JsonProperty("distance")
    public Integer distance;

    @JsonProperty("driving_side")
    public String drivingSide;

    @JsonProperty("weight")
    public Integer weight;

    @JsonProperty("mode")
    public String mode;

    @JsonProperty("geometry")
    public String geometry;

}
