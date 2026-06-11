package com.smartCity.objects.evStations;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class EVStations {

    @JsonProperty("latitude")
    public Double latitude;

    @JsonProperty("longitude")
    public Double longitude;

    @JsonProperty("location_country")
    public String locationCountry;

    @JsonProperty("precision")
    public Precision precision;

    @JsonProperty("station_locator_url")
    public String stationLocatorUrl;

    @JsonProperty("total_results")
    public Integer totalResults;

    @JsonProperty("station_counts")
    public StationCounts stationCounts;

    @JsonProperty("offset")
    public Integer offset;

    @JsonProperty("fuel_stations")
    public List<FuelStation> fuelStations;

}
