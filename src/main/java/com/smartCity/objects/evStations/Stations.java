package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Stations {

    @JsonProperty("total")
    public Integer total;

}
