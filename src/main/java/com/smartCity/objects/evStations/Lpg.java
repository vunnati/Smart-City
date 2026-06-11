package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Lpg {

    @JsonProperty("total")
    public Integer total;

}
