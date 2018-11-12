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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author nabish
 */
@Entity
@Table(name="gallery")
public class galleryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="galleryId")
    int galleryId;
    
    @Column(name = "galleryname")
    public String galleryname;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "gallery", cascade = CascadeType.ALL)
    public List<imageModel> images;
    

    public galleryModel() {
    }

    public galleryModel(int galleryId, String galleryname, List<imageModel> images) {
        this.galleryId = galleryId;
        this.galleryname = galleryname;
        this.images = images;
    }

    public int getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(int galleryId) {
        this.galleryId = galleryId;
    }

    public String getGalleryname() {
        return galleryname;
    }

    public void setGalleryname(String galleryname) {
        this.galleryname = galleryname;
    }

    public List<imageModel> getImages() {
        return images;
    }

    public void setImages(List<imageModel> images) {
        this.images = images;
    }


    
    
}
