/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author dell
 */

@Entity
@Table (name = "teachingstaff")  
public class teachingstaffModel {
      
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "teachingstaffId")
    public int teachingstaffId;
    
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable
    public List<subjectModel> subject;

    public List<subjectModel> getSubject() {
        return subject;
    }

    public void setSubject(List<subjectModel> subject) {
        this.subject = subject;
    }
    
    @Column (name = "username")
    @NotBlank(message = "Please enter the userame")
    public String username;
      
    @Column (name = "teacherUniqueKey")
    @NotBlank(message = "Please enter teachers unique key")
    public String teacherUniqueKey;
   
    @Column (name = "password")
    @NotBlank(message = "Please enter the password")
    public String password;
    
    @Column (name = "teacherName")
    @NotBlank(message = "Please enter teachers name")
    public String teacherName;
    
    @Column (name = "teacherTemporaryAddress")
    @NotBlank(message = "Please enter temporary address")
    public String teacherTemporaryAddress;
    
    @Column (name = "teacherPermanentAddress")
    @NotBlank(message = "Please enter the permanent address")
    public String teacherPermanentAddress;
    
    @Column (name = "teacherPhone")
    @Size(min=7 , message="Mobile number must be minimum of of 7 digits")
    @NotBlank(message = "Please enter the phone number")
    public String teacherPhone;
    
    @Column (name = "teacherMobile")
    @NotBlank(message = "Please enter the mobile number")
    @Size(min=10 , message="Mobile number must be minimum of of 10 digits")
    public String teacherMobile;
     
    @Column (name = "teacherPreviousSchool")
    @NotBlank(message = "Please enter the previous school")
    public String teacherPreviousSchool;
      
    @Column (name = "teacherQualification")
    @NotBlank(message = "Please enter the qualification")
    public String teacherQualification;
       
    @Column (name = "teacherMartialStatus")
    @NotBlank(message = "Please select the marital status")
    public String teacherMartialStatus;
        
    @Column (name = "teacherSalary")
    @Range(min=1 , message = "Salary cannot be 0")
    public int teacherSalary;
    
    @Column (name = "availability")
    public int availability;
    
  /*  @OneToOne
   @JoinColumn
   public classModel classes;

    public classModel getClasses() {
        return classes;
    }

    public void setClasses(classModel classes) {
        this.classes = classes;
    }
    
    @OneToOne
   @JoinColumn
   public sectionModel section;

    public sectionModel getSection() {
        return section;
    }

    public void setSection(sectionModel section) {
        this.section = section;
    }*/
    
    
    public teachingstaffModel(){}

    public teachingstaffModel(int teachingstaffId, String username, String teacherUniqueKey, String password, String teacherName, String teacherTemporaryAddress, String teacherPermanentAddress, String teacherPhone, String teacherMobile, String teacherPreviousSchool, String teacherQualification, String teacherMartialStatus, int teacherSalary) {
        this.teachingstaffId = teachingstaffId;
        this.username = username;
        this.teacherUniqueKey = teacherUniqueKey;
        this.password = password;
        this.teacherName = teacherName;
        this.teacherTemporaryAddress = teacherTemporaryAddress;
        this.teacherPermanentAddress = teacherPermanentAddress;
        this.teacherPhone = teacherPhone;
        this.teacherMobile = teacherMobile;
        this.teacherPreviousSchool = teacherPreviousSchool;
        this.teacherQualification = teacherQualification;
        this.teacherMartialStatus = teacherMartialStatus;
        this.teacherSalary = teacherSalary;
    }

    public String getTeacherUniqueKey() {
        return teacherUniqueKey;
    }

    public void setTeacherUniqueKey(String teacherUniqueKey) {
        this.teacherUniqueKey = teacherUniqueKey;
    }

    public int getTeachingstaffId() {
        return teachingstaffId;
    }

    public void setTeachingstaffId(int teachingstaffId) {
        this.teachingstaffId = teachingstaffId;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherTemporaryAddress() {
        return teacherTemporaryAddress;
    }

    public void setTeacherTemporaryAddress(String teacherTemporaryAddress) {
        this.teacherTemporaryAddress = teacherTemporaryAddress;
    }

    public String getTeacherPermanentAddress() {
        return teacherPermanentAddress;
    }

    public void setTeacherPermanentAddress(String teacherPermanentAddress) {
        this.teacherPermanentAddress = teacherPermanentAddress;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherMobile() {
        return teacherMobile;
    }

    public void setTeacherMobile(String teacherMobile) {
        this.teacherMobile = teacherMobile;
    }

    public String getTeacherPreviousSchool() {
        return teacherPreviousSchool;
    }

    public void setTeacherPreviousSchool(String teacherPreviousSchool) {
        this.teacherPreviousSchool = teacherPreviousSchool;
    }

    public String getTeacherQualification() {
        return teacherQualification;
    }

    public void setTeacherQualification(String teacherQualification) {
        this.teacherQualification = teacherQualification;
    }

    public String getTeacherMartialStatus() {
        return teacherMartialStatus;
    }

    public void setTeacherMartialStatus(String teacherMartialStatus) {
        this.teacherMartialStatus = teacherMartialStatus;
    }

    public int getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(int teacherSalary) {
        this.teacherSalary = teacherSalary;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
}
