/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services.servicesimpl;

import com.sms.dao.staffDao;
import com.sms.model.staffModel;
import com.sms.services.staffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dell
 */

@Service("staffService")
@Transactional
public class staffServicesImpl implements staffServices{

    @Autowired
    staffDao staffDao;
    
    @Override
    public staffModel checkLogin(staffModel login) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return staffDao.checkLogin(login);
    }
}
