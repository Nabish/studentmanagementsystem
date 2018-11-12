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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author nabish
 */
@Entity
@Table(name="marksheet")
public class markSheet {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="markSheetId")
    public int markSheetId;
    
    @Column(name="marksObtained")
    public String marksObtained;
    
    @Column(name="marksObtainedPratical")
    public String marksObtainedPratical;
    
    @Column(name="term")
    public String term;
    
    @Transient
    public String studentRegistrationNumber;
    
    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    public studentModel student;
    
    @Column(name="subjectName")
    public String subjectName;
    
    @Column(name="total")
    public int total;  
    
    @Column (name = "theoryFullMark")
   public String theoryFullMark;
   
   @Column (name = "theoryPassMark")
   public String theoryPassMark;
   
   @Column (name = "practicalFullMark")
   public String practicalFullMark;
   
   @Column (name = "practicalPassMark")
   public String practicalPassMark;

    public markSheet() {
    }

    public markSheet(int markSheetId, String marksObtained, String marksObtainedPratical, String term, String studentRegistrationNumber, studentModel student, String subjectName, int total, String theoryFullMark, String theoryPassMark, String practicalFullMark, String practicalPassMark) {
        this.markSheetId = markSheetId;
        this.marksObtained = marksObtained;
        this.marksObtainedPratical = marksObtainedPratical;
        this.term = term;
        this.studentRegistrationNumber = studentRegistrationNumber;
        this.student = student;
        this.subjectName = subjectName;
        this.total = total;
        this.theoryFullMark = theoryFullMark;
        this.theoryPassMark = theoryPassMark;
        this.practicalFullMark = practicalFullMark;
        this.practicalPassMark = practicalPassMark;
    }

    public String getTheoryFullMark() {
        return theoryFullMark;
    }

    public void setTheoryFullMark(String theoryFullMark) {
        this.theoryFullMark = theoryFullMark;
    }

    public String getTheoryPassMark() {
        return theoryPassMark;
    }

    public void setTheoryPassMark(String theoryPassMark) {
        this.theoryPassMark = theoryPassMark;
    }

    public String getPracticalFullMark() {
        return practicalFullMark;
    }

    public void setPracticalFullMark(String practicalFullMark) {
        this.practicalFullMark = practicalFullMark;
    }

    public String getPracticalPassMark() {
        return practicalPassMark;
    }

    public void setPracticalPassMark(String practicalPassMark) {
        this.practicalPassMark = practicalPassMark;
    }
    
    public int getMarkSheetId() {
        return markSheetId;
    }

    public void setMarkSheetId(int markSheetId) {
        this.markSheetId = markSheetId;
    }

    public String getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(String marksObtained) {
        this.marksObtained = marksObtained;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getStudentRegistrationNumber() {
        return studentRegistrationNumber;
    }

    public void setStudentRegistrationNumber(String studentRegistrationNumber) {
        this.studentRegistrationNumber = studentRegistrationNumber;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getMarksObtainedPratical() {
        return marksObtainedPratical;
    }

    public void setMarksObtainedPratical(String marksObtainedPratical) {
        this.marksObtainedPratical = marksObtainedPratical;
    }

    public studentModel getStudent() {
        return student;
    }

    public void setStudent(studentModel student) {
        this.student = student;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    


   
    
}
