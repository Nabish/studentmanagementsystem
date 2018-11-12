/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author anis
 */

@Entity
@Table (name = "feedback")
public class feedbackModel {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column (name = "feedbackId")
   public int feedbackId; 
   
   @Size(max = 2000)
   @Column(name = "feedback")
   public String feedback;
   
   @Column(name = "viewed")
   public int viewed;
   
   @Column(name = "date")
   public Date receivedDate;

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }
   
   @OneToOne
   @JoinColumn(name="studentId")
   public studentModel student;

    public feedbackModel() {
        
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }


    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public studentModel getStudent() {
        return student;
    }

    public void setStudent(studentModel student) {
        this.student = student;
    }

    public feedbackModel(int feedbackId, String feedback, int viewed, studentModel student) {
        this.feedbackId = feedbackId;
        this.feedback = feedback;
        this.viewed = viewed;
        this.student = student;
    }
   
   
}