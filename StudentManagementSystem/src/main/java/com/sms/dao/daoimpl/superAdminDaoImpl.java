/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao.daoimpl;

import com.sms.dao.superAdminDao;
import com.sms.model.adminModel;
import com.sms.model.productKeyModel;
import com.sms.model.superAdminModel;
import com.sms.model.transportationModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nabish
 */
@Repository("superadmindao")
public class superAdminDaoImpl implements superAdminDao{
        
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public superAdminModel checkUser(superAdminModel sadmin) {
     String username = sadmin.getUsername();
        System.out.println("Daoimpl"+username);
        String password = sadmin.getPassword();
    
        Session session = sessionFactory.openSession();
                    String SQL_QUERY ="from superAdminModel where username='"+username+ "' and password='"+password+"'";
			Query query = session.createQuery(SQL_QUERY);
			
                        List<superAdminModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list.get(0);
			}
                        sadmin.username="notfound";
			session.close();
			return sadmin ;
    }  

    @Override
    public void addschool(adminModel admin) {
        getSession().saveOrUpdate(admin);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String adminActivation(int adminid, String productkey) {
         Session session = sessionFactory.openSession();
            int productkeyid=0; 
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.YEAR, 1);
            Date date = cal.getTime();             
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");          
            String expirydate = null;
            try {
            expirydate = format1.format(date);

            } catch (Exception e1) {
                e1.printStackTrace();
            }

            
            String SQL_QUERY ="from productKeyModel where productkey='"+productkey+ "' and availability=1";
			Query query = session.createQuery(SQL_QUERY);
			
                        List<productKeyModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               String key=list.get(0).getProductkey();
                               productkeyid=list.get(0).getProductkeyid(); 
                                String admin ="update adminModel set activated=1,expirydate='"+expirydate+ "' WHERE adminid='"+adminid+ "'";
                                Query adminquery = getSession().createQuery(admin);
                                adminquery.executeUpdate();
                                String pro ="update productKeyModel set availability=0 WHERE productKeyId='"+productkeyid+ "'";
                                Query proquery = getSession().createQuery(pro);
                                proquery.executeUpdate();
                               return key;
			}
                       
			session.close();
			return "product key is not available or has been used" ;
    }

    @Override
    public void addProductKey(productKeyModel productkey) {
       getSession().saveOrUpdate(productkey);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<productKeyModel> getProductKeyList() {
      return (List<productKeyModel>)getSession().createCriteria(productKeyModel.class).list();
    }

    @Override
    public List<adminModel> getAdminList() {
        return (List<adminModel>)getSession().createCriteria(adminModel.class).list();
    }

    @Override
    public adminModel getAdminById(int adminid) {
         return (adminModel)getSession().get(adminModel.class, adminid);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    

