/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author dell
 */

@Entity
@Table (name = "subject")
public class subjectModel {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name = "subjectId")
   public int subjectId;
  
   @Column (name = "subjectName")
   @NotBlank(message = "Please enter the subject name")
   public String subjectName;
   
   
   @Column (name = "subjectFlag")
   public String subjectFlag;
   
   @Column (name = "theoryFullMark")
   public String theoryFullMark;
   
   @Column (name = "theoryPassMark")
   public String theoryPassMark;
   
   @Column (name = "practicalFullMark")
   public String practicalFullMark;
   
   @Column (name = "practicalPassMark")
   public String practicalPassMark;
   
   @ManyToOne
   @JoinColumn
   public classModel classes;

    public classModel getClasses() {
        return classes;
    }

    public void setClasses(classModel classes) {
        this.classes = classes;
    }
   
   
   
   public subjectModel(){
       
   }

    public subjectModel(int subjectId, String subjectName, String subjectFlag, String theoryFullMark, String theoryPassMark, String practicalFullMark, String practicalPassMark, classModel classes) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectFlag = subjectFlag;
        this.theoryFullMark = theoryFullMark;
        this.theoryPassMark = theoryPassMark;
        this.practicalFullMark = practicalFullMark;
        this.practicalPassMark = practicalPassMark;
        this.classes = classes;
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
    

    public String getSubjectFlag() {
        return subjectFlag;
    }

    public void setSubjectFlag(String subjectFlag) {
        this.subjectFlag = subjectFlag;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

   
   
}
