/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author nabish
 */
@Entity
@Table(name="event")
public class eventModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="eventId")
    public int eventId;
   
    
    @Column(name="startyear")
    public String startyear;
    
        
    @Column(name="startmonth")
    public String startmonth;
            
                
    @Column(name="startday")
    public String startday;
    
    @Column(name="endyear")
    public String endyear;
    
        
    @Column(name="endmonth")
    public String endmonth;
            
                
    @Column(name="endday")
    public String endday;
    
    @Column(name="description")
    public String description;

    public eventModel() {
    }

    public eventModel(int eventId, String startyear, String startmonth, String startday, String endyear, String endmonth, String endday, String description) {
        this.eventId = eventId;
        this.startyear = startyear;
        this.startmonth = startmonth;
        this.startday = startday;
        this.endyear = endyear;
        this.endmonth = endmonth;
        this.endday = endday;
        this.description = description;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getStartyear() {
        return startyear;
    }

    public void setStartyear(String startyear) {
        this.startyear = startyear;
    }

    public String getStartmonth() {
        return startmonth;
    }

    public void setStartmonth(String startmonth) {
        this.startmonth = startmonth;
    }

    public String getStartday() {
        return startday;
    }

    public void setStartday(String startday) {
        this.startday = startday;
    }

    public String getEndyear() {
        return endyear;
    }

    public void setEndyear(String endyear) {
        this.endyear = endyear;
    }

    public String getEndmonth() {
        return endmonth;
    }

    public void setEndmonth(String endmonth) {
        this.endmonth = endmonth;
    }

    public String getEndday() {
        return endday;
    }

    public void setEndday(String endday) {
        this.endday = endday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
}
