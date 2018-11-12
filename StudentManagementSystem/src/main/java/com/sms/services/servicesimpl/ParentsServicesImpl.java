/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services.servicesimpl;

import com.sms.dao.ParentsDao;
import com.sms.model.feedbackModel;
import com.sms.model.markSheet;
import com.sms.model.studentModel;
import com.sms.services.ParentsServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anis
 */
@Service("ParentsServices")
@Transactional
public class ParentsServicesImpl implements ParentsServices{

    @Autowired
    ParentsDao parentsDao;
    
    @Override
    public studentModel checkLogin(studentModel login) {
        return parentsDao.checkLogin(login);
    }

    @Override
    public void addFeedback(feedbackModel addfeedback) {
        parentsDao.addFeedback(addfeedback);
    }

    @Override
    public List<markSheet> getStudentMarksheetById(int studentId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return parentsDao.getStudentMarksheetById(studentId);
    }
    
}
