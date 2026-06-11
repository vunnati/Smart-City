package com.smartCity.objects.evStations;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EvNetworkIds {

    @JsonProperty("station")
    public List<String> station;

    @JsonProperty("posts")
    public List<String> posts;

}
