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
import org.hibernate.annotations.Generated;

/**
 *
 * @author nabish
 */
@Entity
@Table(name="productkey")
public class productKeyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="productKeyId")
    int productkeyid;
    
    @Column(name="productkey")
    public String productkey;
    
    @Column(name="availability")
    public int availability;

    public productKeyModel() {
    }
    
    

    public productKeyModel(int productkeyid, String productkey, int availability) {
        this.productkeyid = productkeyid;
        this.productkey = productkey;
        this.availability = availability;
    }

    public int getProductkeyid() {
        return productkeyid;
    }

    public void setProductkeyid(int productkeyid) {
        this.productkeyid = productkeyid;
    }

    public String getProductkey() {
        return productkey;
    }

    public void setProductkey(String productkey) {
        this.productkey = productkey;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }
    
    
}
