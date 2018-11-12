/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao.daoimpl;

import com.sms.dao.ParentsDao;
import com.sms.model.feedbackModel;
import com.sms.model.markSheet;
import com.sms.model.studentModel;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anis
 */
@Repository("ParentsDao")
public class ParentsDaoImpl implements ParentsDao{
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public studentModel checkLogin(studentModel login) {
        String username = login.getUsername();
        String password = login.getPassword();
        System.out.println("i am here");
        System.out.println(username);
    
        Session session = sessionFactory.openSession();
                    String SQL_QUERY ="from studentModel where username='"+username+ "' and password='"+password+"'";
			     Query query = session.createQuery(SQL_QUERY);
			
                        List<studentModel> list = query.list();
			if ((list != null) && (list.size() > 0)) {
                               return list.get(0);
			}

			session.close();
                        login.username="notfound";
			return login;
    }

    @Override
    public void addFeedback(feedbackModel addfeedback) {
        getSession().saveOrUpdate(addfeedback);
    }

    @Override
    public List<markSheet> getStudentMarksheetById(int studentId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String SQL_QUERY ="from markSheet WHERE student_studentId='"+studentId+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<markSheet> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			
			return null ; 
    }

       
}
