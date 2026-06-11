package com.smartCity.objects.directions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Directions
{
    @JsonProperty("routes")
    public List<Route> routes;

    @JsonProperty("waypoints")
    public List<Waypoint> waypoints;

    @JsonProperty("code")
    public String code;

    @JsonProperty("uuid")
    public String uuid;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

}
