package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Route {

    @JsonProperty("weight_name")
    public String weightName;

    @JsonProperty("weight")
    public Double weight;

    @JsonProperty("duration")
    public Double duration;

    @JsonProperty("distance")
    public Double distance;

    @JsonProperty("legs")
    public List<Leg> legs;

    @JsonProperty("geometry")
    public String geometry;

}
