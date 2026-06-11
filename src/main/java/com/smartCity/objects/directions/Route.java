package com.smartCity.objects.directions;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    public Geometry geometry;

}
