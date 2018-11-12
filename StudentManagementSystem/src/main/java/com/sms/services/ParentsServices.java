/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services;

import com.sms.model.feedbackModel;
import com.sms.model.markSheet;
import com.sms.model.studentModel;
import java.util.List;

/**
 *
 * @author anis
 */
public interface ParentsServices {

    public studentModel checkLogin(studentModel login);

    public void addFeedback(feedbackModel addfeedback);

    public List<markSheet> getStudentMarksheetById(int studentId);
}
