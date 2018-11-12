/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author nabish
 */
@Entity
@Table (name = "section")
public class sectionModel {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name = "sectionUniqueKey")
   public int sectionUniqueKey;
   
   @Column (name = "section") 
   @NotBlank(message = "Please enter the section")
   public String section;
   
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn
   public classModel classes;
   
    public classModel getClasses() {
        return classes;
    }

    public void setClasses(classModel classes) {
        this.classes = classes;
    }
    
    
   
   public sectionModel(){
       
   }

    public sectionModel(int sectionUniqueKey, String section) {
        this.sectionUniqueKey = sectionUniqueKey;
        this.section = section;
    }

    public int getSectionUniqueKey() {
        return sectionUniqueKey;
    }

    public void setSectionUniqueKey(int sectionUniqueKey) {
        this.sectionUniqueKey = sectionUniqueKey;
    }



    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }   
}

