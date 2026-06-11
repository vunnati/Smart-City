package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Precision {

    @JsonProperty("value")
    public Integer value;

    @JsonProperty("name")
    public String name;

    @JsonProperty("types")
    public List<String> types;

}
