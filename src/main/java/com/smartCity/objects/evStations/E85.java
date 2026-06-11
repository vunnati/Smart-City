package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class E85 {
    @JsonProperty("total")
    public Integer total;
}

