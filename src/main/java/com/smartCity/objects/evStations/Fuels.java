package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fuels {

    @JsonProperty("BD")
    public Bd bd;

    @JsonProperty("E85")
    public E85 e85;

    @JsonProperty("ELEC")
    public Elec elec;

    @JsonProperty("HY")
    public Hy hy;

    @JsonProperty("LNG")
    public Lng lng;

    @JsonProperty("CNG")
    public Cng cng;

    @JsonProperty("LPG")
    public Lpg lpg;

}