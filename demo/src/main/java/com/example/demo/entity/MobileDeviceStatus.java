package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * MobileDeviceStatus Entity class
 */
@Entity
@Data
@JsonFilter("customFilter")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MobileDeviceStatus {
    //TODO change this to the DB generated id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;

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

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rcvdTime = new Date();

    @Temporal(TemporalType.DATE)
    private Date rcvdDate = new Date();
}