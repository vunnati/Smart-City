package com.smartCity.webApp.service.application;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("storage")
public class StorageProperties {
    private String location = "src/main/resources/static/images/services";

    public void setLocation(String location) {
        this.location = location;
    }
}
