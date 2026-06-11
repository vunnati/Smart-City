package com.smartCity.objects.evStations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Data
public class FuelStation {

    @JsonProperty("access_code")
    public String accessCode;

    @JsonProperty("access_days_time")
    public String accessDaysTime;

    @JsonProperty("access_detail_code")
    public Object accessDetailCode;

    @JsonProperty("cards_accepted")
    public Object cardsAccepted;

    @JsonProperty("date_last_confirmed")
    public String dateLastConfirmed;

    @JsonProperty("expected_date")
    public Object expectedDate;

    @JsonProperty("fuel_type_code")
    public String fuelTypeCode;

    @JsonProperty("groups_with_access_code")
    public String groupsWithAccessCode;

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("open_date")
    public String openDate;

    @JsonProperty("owner_type_code")
    public Object ownerTypeCode;

    @JsonProperty("status_code")
    public String statusCode;

    @JsonProperty("restricted_access")
    public Object restrictedAccess;

    @JsonProperty("maximum_vehicle_class")
    public Object maximumVehicleClass;

    @JsonProperty("station_name")
    public String stationName;

    @JsonProperty("station_phone")
    public String stationPhone;

    @JsonProperty("updated_at")
    public String updatedAt;

    @JsonProperty("facility_type")
    public Object facilityType;

    @JsonProperty("geocode_status")
    public String geocodeStatus;

    @JsonProperty("latitude")
    public Double latitude;

    @JsonProperty("longitude")
    public Double longitude;

    @JsonProperty("city")
    public String city;

    @JsonProperty("intersection_directions")
    public Object intersectionDirections;

    @JsonProperty("plus4")
    public Object plus4;

    @JsonProperty("state")
    public String state;

    @JsonProperty("street_address")
    public String streetAddress;

    @JsonProperty("zip")
    public String zip;

    @JsonProperty("country")
    public String country;

    @JsonProperty("bd_blends")
    public Object bdBlends;

    @JsonProperty("cng_dispenser_num")
    public Object cngDispenserNum;

    @JsonProperty("cng_fill_type_code")
    public Object cngFillTypeCode;

    @JsonProperty("cng_psi")
    public Object cngPsi;

    @JsonProperty("cng_renewable_source")
    public Object cngRenewableSource;

    @JsonProperty("cng_total_compression")
    public Object cngTotalCompression;

    @JsonProperty("cng_total_storage")
    public Object cngTotalStorage;

    @JsonProperty("cng_vehicle_class")
    public Object cngVehicleClass;

    @JsonProperty("e85_blender_pump")
    public Object e85BlenderPump;

    @JsonProperty("e85_other_ethanol_blends")
    public Object e85OtherEthanolBlends;

    @JsonProperty("ev_connector_types")
    public List<String> evConnectorTypes;

    @JsonProperty("ev_dc_fast_num")
    public Object evDcFastNum;

    @JsonProperty("ev_level1_evse_num")
    public Object evLevel1EvseNum;

    @JsonProperty("ev_level2_evse_num")
    public Integer evLevel2EvseNum;

    @JsonProperty("ev_network")
    public String evNetwork;

    @JsonProperty("ev_network_web")
    public String evNetworkWeb;

    @JsonProperty("ev_other_evse")
    public Object evOtherEvse;

    @JsonProperty("ev_pricing")
    public Object evPricing;

    @JsonProperty("ev_renewable_source")
    public Object evRenewableSource;

    @JsonProperty("hy_is_retail")
    public Object hyIsRetail;

    @JsonProperty("hy_pressures")
    public Object hyPressures;

    @JsonProperty("hy_standards")
    public Object hyStandards;

    @JsonProperty("hy_status_link")
    public Object hyStatusLink;

    @JsonProperty("lng_renewable_source")
    public Object lngRenewableSource;

    @JsonProperty("lng_vehicle_class")
    public Object lngVehicleClass;

    @JsonProperty("lpg_primary")
    public Object lpgPrimary;

    @JsonProperty("lpg_nozzle_types")
    public Object lpgNozzleTypes;

    @JsonProperty("ng_fill_type_code")
    public Object ngFillTypeCode;

    @JsonProperty("ng_psi")
    public Object ngPsi;

    @JsonProperty("ng_vehicle_class")
    public Object ngVehicleClass;

    @JsonProperty("rd_blends")
    public Object rdBlends;

    @JsonProperty("rd_blends_fr")
    public Object rdBlendsFr;

    @JsonProperty("rd_blended_with_biodiesel")
    public Object rdBlendedWithBiodiesel;

    @JsonProperty("rd_max_biodiesel_level")
    public Object rdMaxBiodieselLevel;

    @JsonProperty("access_days_time_fr")
    public Object accessDaysTimeFr;

    @JsonProperty("intersection_directions_fr")
    public Object intersectionDirectionsFr;

    @JsonProperty("bd_blends_fr")
    public Object bdBlendsFr;

    @JsonProperty("groups_with_access_code_fr")
    public String groupsWithAccessCodeFr;

    @JsonProperty("ev_pricing_fr")
    public Object evPricingFr;

    @JsonProperty("ev_network_ids")
    public EvNetworkIds evNetworkIds;

    @JsonProperty("distance")
    public Double distance;

    @JsonProperty("distance_km")
    public Double distanceKm;

}
