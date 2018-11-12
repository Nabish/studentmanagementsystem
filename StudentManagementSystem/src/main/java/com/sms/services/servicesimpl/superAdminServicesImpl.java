/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services.servicesimpl;

import com.sms.dao.superAdminDao;
import com.sms.model.adminModel;
import com.sms.model.productKeyModel;
import com.sms.model.superAdminModel;
import com.sms.services.superAdminServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nabish
 */
@Service("superadminservices")
@Transactional
public class superAdminServicesImpl implements superAdminServices{
    @Autowired
    superAdminDao superadmindao;
    
    @Override
    public superAdminModel checkUser(superAdminModel sadmin) {
        return superadmindao.checkUser(sadmin);
    }

    @Override
    public void addschool(adminModel admin) {
       superadmindao.addschool(admin);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String adminActivation(int adminid, String productkey) {
    return superadmindao.adminActivation(adminid,productkey);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProductKey(productKeyModel productkey) {
      superadmindao.addProductKey(productkey);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<productKeyModel> getProductKeyList() {
        return superadmindao.getProductKeyList();
    }

    @Override
    public List<adminModel> getAdminList() {
      return superadmindao.getAdminList();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public adminModel getAdminById(int adminid) {
       return superadmindao.getAdminById(adminid);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
