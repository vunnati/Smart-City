package com.smartCity.webApp.controller;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonObject;
import com.smartCity.config.mqtt.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MqttController {

    @Autowired
    MqttGateway mqttGateway;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> publish(@RequestBody String mqttMessage){
        JsonObject jsonObject = new Gson().fromJson(mqttMessage, JsonObject.class);
        mqttGateway.senToMqtt(jsonObject.get("message").toString(), jsonObject.get("topic").toString());
        return ResponseEntity.ok("Success");
    }
}
