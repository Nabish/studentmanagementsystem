/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author nabish
 */
@Entity
@Table (name="transportation")
public class transportationModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "transportationId")
    public int transportationId;
    
    @Column (name = "busNumber")
    @Size(min=1,message="Bus number should be at least of size 1")
    public String busNumber;
    
    @Column (name = "busCapacity")
    @Range(min=1 , message = "Bus capacity cannot be 0")
    public int busCapacity;
    
    @Column (name = "busRoute")
    @NotBlank(message = "Please enter bus route")
    public String busRoute;
    
    @Column (name = "driverName")
    @NotBlank(message = "Please enter driver Name")
    public String driverName;
    
    @Column (name = "driverPhone")
    @Size(min=10 , message="min of size 10")
    public String driverPhone;
    
    @Column (name = "driverAddress")
    @NotBlank(message = "Please enter driver Address")
    public String driverAddress;

    public transportationModel(int transportationId, String busNumber, int busCapacity, String busRoute, String driverName, String driverphone, String busAddress) {
        this.transportationId = transportationId;
        this.busNumber = busNumber;
        this.busCapacity = busCapacity;
        this.busRoute = busRoute;
        this.driverName = driverName;
        this.driverPhone = driverPhone;
        this.driverAddress = driverAddress;
    }

    public transportationModel() {
    }

    public int getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(int transportationId) {
        this.transportationId = transportationId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public int getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        this.busCapacity = busCapacity;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverphone) {
        this.driverPhone = driverphone;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String busAddress) {
        this.driverAddress = busAddress;
    }
    
    
}
