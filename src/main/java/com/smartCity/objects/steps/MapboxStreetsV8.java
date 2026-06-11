package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MapboxStreetsV8 {

    @JsonProperty("class")
    public String _class;

}