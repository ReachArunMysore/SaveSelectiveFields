package com.example.demo.service;

import com.example.demo.dto.MobileDeviceStatusDto;
import com.example.demo.entity.MobileDeviceStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class JsonAfterBurnerTest {

    @Autowired
    private JsonAfterBurner jsonAfterBurner;

    @Test
    void profileJsonAfterBurner() {
        String json = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            json = new String(Files.readAllBytes(Paths.get("src/test/resources/input.json")),
                    StandardCharsets.UTF_8);
            List<MobileDeviceStatusDto> mobileDeviceStatusList = new ArrayList<>();
            for(int i=0; i<10000; i++) {
                mobileDeviceStatusList.add(mapper.readValue(json, MobileDeviceStatusDto.class));
            }
            System.out.println("List Size - "+mobileDeviceStatusList.size());
            long startTime = System.currentTimeMillis();
            System.out.println("startTime"+startTime);
            jsonAfterBurner.profileAfterBurner(mobileDeviceStatusList);
            System.out.println("Time taken - "+ (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            System.out.println("Exception e"+e.getMessage());
        }
    }

    @Test
    void profileNormalObjectMapper() {
        String json = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            json = new String(Files.readAllBytes(Paths.get("src/test/resources/input.json")),
                    StandardCharsets.UTF_8);
            List<MobileDeviceStatusDto> mobileDeviceStatusList = new ArrayList<>();
            for(int i=0; i<10000; i++) {
                mobileDeviceStatusList.add(mapper.readValue(json, MobileDeviceStatusDto.class));
            }
            System.out.println("List Size - "+mobileDeviceStatusList.size());
            long startTime = System.currentTimeMillis();
            System.out.println("startTime"+startTime);
            jsonAfterBurner.profileNormalObjectMapper(mobileDeviceStatusList);
            System.out.println("Time taken - "+ (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            System.out.println("Exception e"+e.getMessage());
        }
    }
}
