/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao;

import com.sms.model.adminModel;
import com.sms.model.productKeyModel;
import com.sms.model.superAdminModel;
import java.util.List;

/**
 *
 * @author nabish
 */
public interface superAdminDao {

    public superAdminModel checkUser(superAdminModel sadmin);

    public void addschool(adminModel admin);

    public String adminActivation(int adminid, String productkey);

    public void addProductKey(productKeyModel productkey);

    public List<productKeyModel> getProductKeyList();

    public List<adminModel> getAdminList();

    public adminModel getAdminById(int adminid);
    
}
