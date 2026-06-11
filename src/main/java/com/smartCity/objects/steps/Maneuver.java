package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Maneuver {

    @JsonProperty("type")
    public String type;

    @JsonProperty("instruction")
    public String instruction;

    @JsonProperty("bearing_after")
    public Integer bearingAfter;

    @JsonProperty("bearing_before")
    public Integer bearingBefore;

    @JsonProperty("location")
    public List<Double> location;

    @JsonProperty("modifier")
    public String modifier;

}
