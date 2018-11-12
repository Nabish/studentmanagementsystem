/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao.daoimpl;

import com.sms.dao.staffDao;
import com.sms.model.staffModel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */

@Repository("staffDao")
public class staffDaoImpl implements staffDao{
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    } 


    @Override
    public staffModel checkLogin(staffModel login) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
 String username = login.getUsername();
        System.out.println("Daoimpl"+username);
    String password = login.getPassword();
    
    Session session = sessionFactory.openSession();
                    String SQL_QUERY ="from staffModel where username='"+username+ "' and password='"+password+"'";
			     Query query = session.createQuery(SQL_QUERY);
			
                        List<staffModel> list = query.list();
                       System.out.println("Before"); 
                       System.out.println("After"); 
                  
			if ((list != null) && (list.size() > 0)) {
                               return list.get(0);
			}
                        login.username="notfound"; 
			session.close();
			return login ;
    }   
}
    

