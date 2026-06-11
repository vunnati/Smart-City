package com.smartCity.objects.steps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Admin {

    @JsonProperty("iso_3166_1_alpha3")
    public String iso31661Alpha3;

    @JsonProperty("iso_3166_1")
    public String iso31661;

}
