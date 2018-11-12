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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author anis
 */
@Entity
@Table (name = "class")
public class classModel {
    @Id
    @Column (name = "classUniqueKey")
    @NotBlank(message = "Class Unique Key cannot be empty")
    public String classUniqueKey;
    
    @Column (name = "className")
    @NotBlank(message = "Class Name cannot be empty")
    public String className;
    
    @Column (name = "classCapacity")
    @NotBlank(message = "Class Capacity cannot be empty")
    public String classCapacity;
   
   
 /*   @JoinTable
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<studentModel> students;

    public List<studentModel> getStudents() {
        return students;
    }

    public void setStudents(List<studentModel> students) {
        this.students = students;
    }*/
    
    

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "classes", cascade = CascadeType.ALL)
    public List<sectionModel> sections;

    public List<sectionModel> getSections() {
        return sections;
    }

    public void setSections(List<sectionModel> sections) {
        this.sections = sections;
    }
    
    
   @OneToOne(mappedBy = "classes")
    @JoinColumn
    public feeModel fees;

    public feeModel getFees() {
        return fees;
    }

    public void setFees(feeModel fees) {
        this.fees = fees;
    }

    public List<classModel> getClasses() {
        return classes;
    }

    public void setClasses(List<classModel> classes) {
        this.classes = classes;
    }
    
    
   @OneToMany(cascade = CascadeType.ALL)
   @JoinTable
   public List<classModel> classes;
    
    public classModel() {
    }

    public classModel(String classUniqueKey, String className, String classCapacity) {
        this.classUniqueKey = classUniqueKey;
        this.className = className;
        this.classCapacity = classCapacity;
    }

    

    public String getClassUniqueKey() {
        return classUniqueKey;
    }

    public void setClassUniqueKey(String classUniqueKey) {
        this.classUniqueKey = classUniqueKey;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(String classCapacity) {
        this.classCapacity = classCapacity;
    }
    

}
