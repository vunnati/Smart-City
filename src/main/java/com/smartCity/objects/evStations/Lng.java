package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Lng {

    @JsonProperty("total")
    public Integer total;

}
