/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size; 
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author anis
 */
@Entity
@Table (name = "students")
public class studentModel {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name = "studentId")
   public int studentId;
   
   
   @Column(name = "studentRegistrationNumber")
   @NotBlank(message = "Please enter the registration number")
   public String studentRegistrationNumber;
   
   @Column(name = "studentFirstname")
   @NotBlank(message = "Please enter the first name")
   public String studentFirstname;
   
   @Column(name = "studentMiddlename")
   public String studentMiddlename;
   
   @Column(name = "studentLastname")
   @NotBlank(message = "Please enter the last name")
   public String studentLastname;
   
   @Column(name = "studentFathername")
   @NotBlank(message = "Please enter the father's name")
   public String studentFathername;
   
   @Column(name = "studentMothername")
   @NotBlank(message = "Please enter the mother's name")
   public String studentMothername;
   
   @Transient
   public String studentDOB;
   
   @Column(name = "studentdateofbirth")
   public Date studentDateofbirth;
   
   @Column(name = "studentTemporaryAddress")
   @NotBlank(message = "Please enter the temporary address")
   public String studentTemporaryAddress;
   
   @Column(name = "studentPermanentAddress")
   @NotBlank(message = "Please enter the permanent address")
   public String studentPermanentAddress;
   
   @Column(name = "studentSex")
   @NotBlank(message = "Please select the sex")
   public String studentSex;
   
   @Column(name = "studentFatherOccupation")
   @NotBlank(message = "Please enter the father's occupation")
   public String studentFatherOccupation;
   
   @Column(name = "studentMotherOccupation")
   @NotBlank(message = "Please enter the mother's occupation")
   public String studentMotherOccupation;
   
   @Column(name = "studentFatherNumber")
   @NotBlank(message = "Please enter the mobile number")
    @Size(min=10 , message="Mobile number muat be minimum of of 10 digits")
   public String studentFatherNumber;
   
   @Column(name = "studentMotherNumber")
   @NotBlank(message = "Please enter the mobile number")
    @Size(min=10 , message="Mobile number muat be minimum of of 10 digits")
   public String studentMotherNumber;
   
   @Column(name = "studentPhoneNumber")
   @Size(min=7 , message="Mobile number muat be minimum of of 7 digits")
    @NotBlank(message = "Please enter the phone number")
   public String studentPhoneNumber;
   
   @Column(name = "email")
   public String email;
   
   @Column(name="studentAvailable")
   public int studentAvailable; 
   
   @Column(name="username")
   public String username; 
   
   @Column(name="password")
   public String password; 
   
   @Column (name = "transportationFlag")
   public String transportationFlag;


   
   
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "student")
    public List<markSheet> marksheet;

    public List<markSheet> getMarksheet() {
        return marksheet;
    }

    public void setMarksheet(List<markSheet> marksheet) {
        this.marksheet = marksheet;
    }
    
   
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn
   public classModel classes;
   
    public classModel getClasses() {
        return classes;
    }

    public void setClasses(classModel classes) {
        this.classes = classes;
    }
   
    @ManyToOne
    @JoinColumn
    public sectionModel section;

    public sectionModel getSection() {
        return section;
    }

    public void setSection(sectionModel sections) {
        this.section = sections;
    }
    
     @Transient
    public int grandtotal;

    public int getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(int grandtotal) {
        this.grandtotal = grandtotal;
    }
    
    @Transient
    public String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    @Transient
    public float percentage;

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    
    @Transient
    public String division;

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
    
   
   @Transient
   public MultipartFile file;
   
   @Column(name = "studentPhoto")
   public String studentPhoto;
   
    private String code;

    public studentModel() {
          this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();

    }

    public studentModel(int studentId, String studentRegistrationNumber, String studentFirstname, String studentMiddlename, String studentLastname, String studentFathername, String studentMothername, String studentDOB, String studentTemporaryAddress, String studentPermanentAddress, String studentSex, String studentFatherOccupation, String studentMotherOccupation, String studentFatherNumber, String studentMotherNumber, String studentPhoneNumber, String classUniqueKey, String sectionUniqueKey, MultipartFile file, String studentPhoto, String code) {
        this.studentId = studentId;
        this.studentRegistrationNumber = studentRegistrationNumber;
        this.studentFirstname = studentFirstname;
        this.studentMiddlename = studentMiddlename;
        this.studentLastname = studentLastname;
        this.studentFathername = studentFathername;
        this.studentMothername = studentMothername;
        this.studentDOB = studentDOB;
        this.studentTemporaryAddress = studentTemporaryAddress;
        this.studentPermanentAddress = studentPermanentAddress;
        this.studentSex = studentSex;
        this.studentFatherOccupation = studentFatherOccupation;
        this.studentMotherOccupation = studentMotherOccupation;
        this.studentFatherNumber = studentFatherNumber;
        this.studentMotherNumber = studentMotherNumber;
        this.studentPhoneNumber = studentPhoneNumber;
        this.file = file;
        this.studentPhoto = studentPhoto;
        this.code = code;
    }

    public studentModel(String username, String password) {
        this.username = username;
        this.password = password;
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

    
    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public void setStudentRegistrationNumber(String studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentMiddlename() {
        return studentMiddlename;
    }

    public void setStudentMiddlename(String studentMiddlename) {
        this.studentMiddlename = studentMiddlename;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public String getStudentFathername() {
        return studentFathername;
    }

    public void setStudentFathername(String studentFathername) {
        this.studentFathername = studentFathername;
    }

    public String getStudentMothername() {
        return studentMothername;
    }

    public void setStudentMothername(String studentMothername) {
        this.studentMothername = studentMothername;
    }

    public String getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(String studentDOB) {
        this.studentDOB = studentDOB;
    }

    public String getStudentTemporaryAddress() {
        return studentTemporaryAddress;
    }

    public void setStudentTemporaryAddress(String studentTemporaryAddress) {
        this.studentTemporaryAddress = studentTemporaryAddress;
    }

    public String getStudentPermanentAddress() {
        return studentPermanentAddress;
    }

    public void setStudentPermanentAddress(String studentPermanentAddress) {
        this.studentPermanentAddress = studentPermanentAddress;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentFatherOccupation() {
        return studentFatherOccupation;
    }

    public void setStudentFatherOccupation(String studentFatherOccupation) {
        this.studentFatherOccupation = studentFatherOccupation;
    }

    public String getStudentMotherOccupation() {
        return studentMotherOccupation;
    }

    public void setStudentMotherOccupation(String studentMotherOccupation) {
        this.studentMotherOccupation = studentMotherOccupation;
    }

    public String getStudentFatherNumber() {
        return studentFatherNumber;
    }

    public void setStudentFatherNumber(String studentFatherNumber) {
        this.studentFatherNumber = studentFatherNumber;
    }

    public String getStudentMotherNumber() {
        return studentMotherNumber;
    }

    public void setStudentMotherNumber(String studentMotherNumber) {
        this.studentMotherNumber = studentMotherNumber;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getStudentPhoto() {
        return studentPhoto;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStudentAvailable() {
        return studentAvailable;
    }

    public void setStudentAvailable(int studentAvailable) {
        this.studentAvailable = studentAvailable;
    }

    public Date getStudentDateofbirth() {
        return studentDateofbirth;
    }

    public void setStudentDateofbirth(Date studentDateofbirth) {
        this.studentDateofbirth = studentDateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTransportationFlag() {
        return transportationFlag;
    }

    public void setTransportationFlag(String transportationFlag) {
        this.transportationFlag = transportationFlag;
    }
    
    
}
