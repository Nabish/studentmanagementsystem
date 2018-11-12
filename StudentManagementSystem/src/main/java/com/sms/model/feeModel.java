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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.hibernate.validator.constraints.Range;


@Entity
@Table (name = "fee")
public class feeModel {
     @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name = "feeId")
   public int feeId;
     
   @Column (name = "classUniqueKey")
   public String classUniqueKey;
   
   @Column (name = "tutionfee")
   @Range(min=1 , message = "Tution fee cannot be 0")
   public int tutionfee;
   
   @Column (name = "transportationfee")
   @Range(min=1 , message = "Transportaition fee cannot be 0")
   public int transportationfee;
   
   @Column (name = "ecafee")
   @Range(min=1 , message = "ECA fee cannot be 0")
   public int ecafee;
   
   @Column (name = "libraryfee")
   @Range(min=1 , message = "Library fee cannot be 0")
   public int libraryfee;
   
   @Column (name = "computerfee")
   @Range(min=1 , message = "Computer fee cannot be 0")
   public int computerfee;
   
   @OneToOne
   @JoinColumn(name="classfee")
   public classModel classes;

    public classModel getClasses() {
        return classes;
    }

    public void setClasses(classModel classes) {
        this.classes = classes;
    }
   
   
   
   public feeModel(){
       
   }

    public feeModel(int feeId, String classUniqueKey, int tutionfee, int transportationfee, int ecafee, int libraryfee, int computerfee) {
        this.feeId = feeId;
        this.classUniqueKey = classUniqueKey;
        this.tutionfee = tutionfee;
        this.transportationfee = transportationfee;
        this.ecafee = ecafee;
        this.libraryfee = libraryfee;
        this.computerfee = computerfee;
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public String getClassUniqueKey() {
        return classUniqueKey;
    }

    public void setClassUniqueKey(String classUniqueKey) {
        this.classUniqueKey = classUniqueKey;
    }

    public int getTutionfee() {
        return tutionfee;
    }

    public void setTutionfee(int tutionfee) {
        this.tutionfee = tutionfee;
    }

    public int getTransportationfee() {
        return transportationfee;
    }

    public void setTransportationfee(int transportationfee) {
        this.transportationfee = transportationfee;
    }

    public int getEcafee() {
        return ecafee;
    }

    public void setEcafee(int ecafee) {
        this.ecafee = ecafee;
    }

    public int getLibraryfee() {
        return libraryfee;
    }

    public void setLibraryfee(int libraryfee) {
        this.libraryfee = libraryfee;
    }

    public int getComputerfee() {
        return computerfee;
    }

    public void setComputerfee(int computerfee) {
        this.computerfee = computerfee;
    }
    
   
}
