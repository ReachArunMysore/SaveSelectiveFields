package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MobileDeviceStatusDto {
    private float batteryPercent;
    private Boolean charging;
    private String chargingType;
    private float batteryTemperature;
    private String batteryHealth;
    private int batteryVoltage;
    private float ambientTemperature;
    private String networkOperator;
    private String dataStatus;
    private String networkType;
    private Date rcvdTime = new Date();
    private Date rcvdDate = new Date();
}
