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



/**
 *
 * @author nabish
 */
@Entity
@Table(name="superadmin")
public class superAdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="superadminId")
    public int superadminId;
    
    @Column(name="username")
    public String username;
    
    @Column(name="password")
    public String password;

    public superAdminModel() {
    }

    public superAdminModel(int superadminId, String username, String password) {
        this.superadminId = superadminId;
        this.username = username;
        this.password = password;
    }

    public int getSuperadminId() {
        return superadminId;
    }

    public void setSuperadminId(int superadminId) {
        this.superadminId = superadminId;
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
    
}
