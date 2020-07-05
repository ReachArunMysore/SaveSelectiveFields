package com.example.demo.service;

import com.example.demo.entity.MobileDeviceStatus;
import com.example.demo.repo.MobileDeviceStatusRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MobileDeviceStatusService {

    @Autowired
    private MobileDeviceStatusRepo mobileDeviceStatusRepo;

    @Value("${my.list.of.strings}")
    Set<String> includedFieldsStringSet;

    /**
     * Converts the String into {@link MobileDeviceStatus}, filters the JSON based on the includedFieldsStringSet,
     * Calls the repo to save the {@link MobileDeviceStatus}
     * {@link MobileDeviceStatusRepo}
     *
     * @param deviceStatusString The JSON string
     * @return MobileDeviceStatus object on successfully saving the {@link MobileDeviceStatus}
     * null when there are any exceptions
     */
    public MobileDeviceStatus saveDeviceStatus(String deviceStatusString) {
        ObjectMapper om = new ObjectMapper();
        try {
            MobileDeviceStatus mobileDeviceStatus = om.readValue(deviceStatusString, MobileDeviceStatus.class);
            System.out.println("deviceStatusString - "+ mobileDeviceStatus);
            if (!includedFieldsStringSet.isEmpty()) {
                FilterProvider filterProvider = new SimpleFilterProvider().addFilter("customFilter",
                        SimpleBeanPropertyFilter.filterOutAllExcept(includedFieldsStringSet));
                String jsonString = om.writer(filterProvider).writeValueAsString(mobileDeviceStatus);
                System.out.println("jsonString - " + jsonString);
                mobileDeviceStatus = om.readValue(jsonString, MobileDeviceStatus.class);
            }
            return mobileDeviceStatusRepo.save(mobileDeviceStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
