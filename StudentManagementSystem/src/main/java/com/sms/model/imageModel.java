/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author nabish
 */
@Entity
@Table(name = "image")
public class imageModel {
   @Transient
    private String code;
    
   @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="imageid")
    public int imageid;
    
    @Column(name="imagePath")
    public String imagePath;
    
    @ManyToOne
    @JoinColumn
    public galleryModel gallery;
    
    @Transient
   public MultipartFile[] file;

    public imageModel() {
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }



    public galleryModel getGallery() {
        return gallery;
    }

    public void setGallery(galleryModel gallery) {
        this.gallery = gallery;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
