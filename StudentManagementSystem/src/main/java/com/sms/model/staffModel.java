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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author anis
 */
@Entity
@Table (name = "staff")
public class staffModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "staffId")
    public int staffId;

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
   
   @Column (name = "username")
   public String username;
   
   @Column (name = "password")
   public String password;
    
    @Column (name = "staffName")
    @NotBlank(message = "Please enter the name")
    public String staffName;
    
    @Column (name = "staffTemporaryAddress")
    @NotBlank(message = "Please enter the temporary address")
    public String staffTemporaryAddress;
    
    @Column (name = "staffPermanentAddress")
    @NotBlank(message = "Please enter the permanent address")
    public String staffPermanentAddress;
    
    @Column (name = "staffPhone")
    @Size(min=7 , message="Mobile number muat be minimum of of 7 digits")
    @NotBlank(message = "Please enter the phone number")
    public String staffPhone;
    
    @Column (name = "staffMobile")
    @NotBlank(message = "Please enter the mobile number")
    @Size(min=10 , message="Mobile number muat be minimum of of 10 digits")
    public String staffMobile;
     
    @Column (name = "staffQualification")
    @NotBlank(message = "Please enter the qualification")
    public String staffQualification;
       
    @Column (name = "staffMartialStatus")
    @NotBlank(message = "Please select the marital status")
    public String staffMartialStatus;
        
    @Column (name = "staffSalary")
    @Range(min=1 , message = "Salary cannot be 0")
    public int staffSalary;
    
    @Column (name = "role")
    @NotBlank(message = "Please select the role")
    public String role;
    
    @Column(name="staffAvailable")
   public int staffAvailable; 

    public int getStaffAvailable() {
        return staffAvailable;
    }

    public void setStaffAvailable(int staffAvailable) {
        this.staffAvailable = staffAvailable;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTemporaryAddress() {
        return staffTemporaryAddress;
    }

    public void setStaffTemporaryAddress(String staffTemporaryAddress) {
        this.staffTemporaryAddress = staffTemporaryAddress;
    }

    public String getStaffPermanentAddress() {
        return staffPermanentAddress;
    }

    public void setStaffPermanentAddress(String staffPermanentAddress) {
        this.staffPermanentAddress = staffPermanentAddress;
    }


    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getStaffMobile() {
        return staffMobile;
    }

    public void setStaffMobile(String staffMobile) {
        this.staffMobile = staffMobile;
    }
    public String getStaffQualification() {
        return staffQualification;
    }

    public void setStaffQualification(String staffQualification) {
        this.staffQualification = staffQualification;
    }

    public String getStaffMartialStatus() {
        return staffMartialStatus;
    }

    public void setStaffMartialStatus(String staffMartialStatus) {
        this.staffMartialStatus = staffMartialStatus;
    }

    public int getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(int staffSalary) {
        this.staffSalary = staffSalary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public staffModel(int staffId, String staffName, String staffTemporaryAddress, String staffPermanentAddress, String staffPhone, String staffMobile, String staffQualification, String staffMartialStatus, int staffSalary, String role, String username, String password) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffTemporaryAddress = staffTemporaryAddress;
        this.staffPermanentAddress = staffPermanentAddress;
        this.staffPhone = staffPhone;
        this.staffMobile = staffMobile;
        this.staffQualification = staffQualification;
        this.staffMartialStatus = staffMartialStatus;
        this.staffSalary = staffSalary;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public staffModel() {
    }
}
