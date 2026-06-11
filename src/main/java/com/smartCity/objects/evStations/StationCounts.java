package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StationCounts {

    @JsonProperty("total")
    public Integer total;

    @JsonProperty("fuels")
    public Fuels fuels;

}
