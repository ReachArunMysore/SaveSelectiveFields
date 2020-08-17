package com.example.demo.service;

import com.example.demo.dto.MobileDeviceStatusDto;
import com.example.demo.entity.MobileDeviceStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonAfterBurner {

    public void profileAfterBurner(List<MobileDeviceStatusDto> mobileDeviceStatusDtos) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new AfterburnerModule());
        Long startTime = System.currentTimeMillis();
        String json = mapper.writeValueAsString(mobileDeviceStatusDtos);

        MobileDeviceStatusDto[] deserializedMobileDeviceStatusList = mapper.readValue(json,
                MobileDeviceStatusDto[].class);
        List<MobileDeviceStatusDto> mcList = new ArrayList<>(Arrays.asList(deserializedMobileDeviceStatusList));
        System.out.println("Time taken -"+(System.currentTimeMillis()-startTime));
        System.out.println("List size - "+mcList.size());
    }

    public void profileNormalObjectMapper(List<MobileDeviceStatusDto> mobileDeviceStatusDtos) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Long startTime = System.currentTimeMillis();

        String json = mapper.writeValueAsString(mobileDeviceStatusDtos);

        MobileDeviceStatusDto[] deserializedMobileDeviceStatusList = mapper.readValue(json,
                MobileDeviceStatusDto[].class);
        List<MobileDeviceStatusDto> mcList = new ArrayList<>(Arrays.asList(deserializedMobileDeviceStatusList));
        System.out.println("Time taken -"+(System.currentTimeMillis()-startTime));

        System.out.println("List size - "+mcList.size());

    }
}
