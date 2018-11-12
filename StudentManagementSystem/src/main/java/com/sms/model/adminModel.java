/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nabish
 */
@Entity
@Table (name = "admin")
public class adminModel {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="adminId")
    public int adminid;
   
    @Column(name="schoolName")
    public String schoolName;
    
    @Column(name="schoolAddress")
    public String schoolAddress;
    
    @Column(name="schoolPhoneNumber")
    public String schoolPhoneNumber;
    
    @Column(name="schoolEmail")
    public String schoolEmail;
    
    @Column(name="schoolLogo")
    public String schoolLogo;
    
    @Column(name="username")
    public String username;
    
    @Column(name="password")
    public String password;
    
    @Transient
    public MultipartFile logo;
    
    private String code;
    
    @Column(name="staff")
    public Boolean Staff;
    
    @Column(name="Attendance")
    public Boolean Attendance;
    
    @Column(name="Transportation")
    public Boolean Transportation;
    
    @Column(name="Gallery")
    public Boolean Gallery;
    
    @Column(name="FinanceReport")
    public Boolean FinanceReport;
    
    @Column(name="Event")
    public Boolean Event;
    
    @Column(name="Marksheet")
    public Boolean Marksheet;
    
    @Column(name="FeedBack")
    public Boolean FeedBack;
    
    @Column(name="Fee")
    public Boolean Fee;

    @Column(name="activated")
    public int activated;
    
    @Transient
    public String expirydatestring;
   
    @Column(name="expirydate")
     @Temporal(TemporalType.DATE)
    public Date expirydate;
    
    public adminModel() {
          this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public adminModel(int adminid, String schoolName, String schoolAddress, String schoolPhoneNumber, String schoolEmail, String schoolLogo, String username, String password, MultipartFile logo, String code, Boolean Staff, Boolean Attendance, Boolean Transportation, Boolean Gallery, Boolean FinanceReport, Boolean Event, Boolean Marksheet, Boolean FeedBack, Boolean Fee, int activated, Date expirydate) {
        this.adminid = adminid;
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
        this.schoolPhoneNumber = schoolPhoneNumber;
        this.schoolEmail = schoolEmail;
        this.schoolLogo = schoolLogo;
        this.username = username;
        this.password = password;
        this.logo = logo;
        this.code = code;
        this.Staff = Staff;
        this.Attendance = Attendance;
        this.Transportation = Transportation;
        this.Gallery = Gallery;
        this.FinanceReport = FinanceReport;
        this.Event = Event;
        this.Marksheet = Marksheet;
        this.FeedBack = FeedBack;
        this.Fee = Fee;
        this.activated = activated;
        this.expirydate = expirydate;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolPhoneNumber() {
        return schoolPhoneNumber;
    }

    public void setSchoolPhoneNumber(String schoolPhoneNumber) {
        this.schoolPhoneNumber = schoolPhoneNumber;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getSchoolLogo() {
        return schoolLogo;
    }

    public void setSchoolLogo(String schoolLogo) {
        this.schoolLogo = schoolLogo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getStaff() {
        return Staff;
    }

    public void setStaff(Boolean Staff) {
        this.Staff = Staff;
    }

    public Boolean getAttendance() {
        return Attendance;
    }

    public void setAttendance(Boolean Attendance) {
        this.Attendance = Attendance;
    }

    public Boolean getTransportation() {
        return Transportation;
    }

    public void setTransportation(Boolean Transportation) {
        this.Transportation = Transportation;
    }

    public Boolean getGallery() {
        return Gallery;
    }

    public void setGallery(Boolean Gallery) {
        this.Gallery = Gallery;
    }

    public Boolean getFinanceReport() {
        return FinanceReport;
    }

    public void setFinanceReport(Boolean FinanceReport) {
        this.FinanceReport = FinanceReport;
    }

    public Boolean getEvent() {
        return Event;
    }

    public void setEvent(Boolean Event) {
        this.Event = Event;
    }

    public Boolean getMarksheet() {
        return Marksheet;
    }

    public void setMarksheet(Boolean Marksheet) {
        this.Marksheet = Marksheet;
    }

    public Boolean getFeedBack() {
        return FeedBack;
    }

    public void setFeedBack(Boolean FeedBack) {
        this.FeedBack = FeedBack;
    }

    public Boolean getFee() {
        return Fee;
    }

    public void setFee(Boolean Fee) {
        this.Fee = Fee;
    }

    public int getActivated() {
        return activated;
    }

    public void setActivated(int activated) {
        this.activated = activated;
    }

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    public String getExpirydatestring() {
        return expirydatestring;
    }

    public void setExpirydatestring(String expirydatestring) {
        this.expirydatestring = expirydatestring;
    }

    
}