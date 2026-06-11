package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Elec {

    @JsonProperty("total")
    public Integer total;

    @JsonProperty("stations")
    public Stations stations;

}