package com.example.demo.service;

import com.example.demo.entity.MobileDeviceStatus;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @SpringBootTest was added to load the spring container
 */
@SpringBootTest
class MobileDeviceStatusServiceTest {

    @Autowired
    private MobileDeviceStatusService mobileDeviceStatusService;

    @Test
    void saveDeviceStatusEntry() {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Paths.get("src/test/resources/input.json")),
                    StandardCharsets.UTF_8);
            MobileDeviceStatus mobileDeviceStatus = mobileDeviceStatusService.saveDeviceStatus(json);
            //batteryPercent, charging, chargingType, batteryTemperature
            Assert.assertEquals(mobileDeviceStatus.getBatteryPercent(), 52.999996,0.000005);
            Assert.assertFalse(mobileDeviceStatus.getCharging());
            Assert.assertTrue("na".equalsIgnoreCase(mobileDeviceStatus.getChargingType()));
            Assert.assertEquals(mobileDeviceStatus.getBatteryTemperature(), 0.0f,0.1f);
            Assert.assertNull(mobileDeviceStatus.getBatteryHealth());
            Assert.assertEquals(mobileDeviceStatus.getBatteryVoltage(), 0);
            Assert.assertEquals(mobileDeviceStatus.getAmbientTemperature(), 0.0f,0.0);
            Assert.assertTrue(StringUtils.isAllBlank(mobileDeviceStatus.getNetworkOperator()));
            Assert.assertNull(mobileDeviceStatus.getDataStatus());
            Assert.assertNull(mobileDeviceStatus.getNetworkType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}