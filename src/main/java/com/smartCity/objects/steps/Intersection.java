package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Intersection {

    @JsonProperty("entry")
    public List<Boolean> entry;

    @JsonProperty("bearings")
    public List<Integer> bearings;

    @JsonProperty("duration")
    public Double duration;

    @JsonProperty("mapbox_streets_v8")
    public MapboxStreetsV8 mapboxStreetsV8;

    @JsonProperty("is_urban")
    public Boolean isUrban;

    @JsonProperty("admin_index")
    public Integer adminIndex;

    @JsonProperty("out")
    public Integer out;

    @JsonProperty("weight")
    public Double weight;

    @JsonProperty("geometry_index")
    public Integer geometryIndex;

    @JsonProperty("location")
    public List<Double> location;

    @JsonProperty("in")
    public Integer in;

    @JsonProperty("turn_weight")
    public Double turnWeight;

    @JsonProperty("turn_duration")
    public Double turnDuration;

    @JsonProperty("traffic_signal")
    public Boolean trafficSignal;

    @JsonProperty("classes")
    public List<String> classes;

}
