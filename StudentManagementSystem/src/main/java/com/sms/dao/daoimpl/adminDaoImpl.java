/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.dao.daoimpl;

import com.sms.dao.adminDao;
import com.sms.model.adminModel;
import com.sms.model.classModel;
import com.sms.model.eventModel;
import com.sms.model.feeModel;
import com.sms.model.feedbackModel;
import com.sms.model.galleryModel;
import com.sms.model.imageModel;
import com.sms.model.markSheet;
import com.sms.model.sectionModel;
import com.sms.model.staffModel;
import com.sms.model.studentModel;
import com.sms.model.subjectModel;
import com.sms.model.teachingstaffModel;
import com.sms.model.transportationModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
@Repository("admindao")
public class adminDaoImpl implements adminDao{

    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public adminModel adminLogin(adminModel admindata) {
        String username = admindata.getUsername();
        System.out.println("Daoimpl"+username);
        String password = admindata.getPassword();
    
        Session session = sessionFactory.openSession();
                    String SQL_QUERY ="from adminModel where username='"+username+ "' and password='"+password+"'";
			Query query = session.createQuery(SQL_QUERY);
			
                        List<adminModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list.get(0);
			}
                        admindata.username="notfound";
			session.close();
			return admindata ;
    }

    @Override
    public void addClass(classModel classmodel) {
        getSession().saveOrUpdate(classmodel);
    }

    @Override
    public void addStaff(staffModel staffmodel) {
        getSession().saveOrUpdate(staffmodel);
    }

    @Override
    public void addSubject(subjectModel subject) {
        getSession().saveOrUpdate(subject);
    }

    @Override
    public void addFee(feeModel fee) {
        getSession().saveOrUpdate(fee);
    }
    
        @Override
    public void addStudent(studentModel studentinfo) {
           getSession().saveOrUpdate(studentinfo);  
    }
    
        @Override
    public void addTransportation(transportationModel transportationinfo) {
        getSession().saveOrUpdate(transportationinfo);
    }

    @Override
    public void addSection(sectionModel section) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        getSession().saveOrUpdate(section);
    }

    @Override
    public List<classModel> getClasses() {
                        Session session = sessionFactory.openSession();
			//Query using Hibernate Query Language
			String SQL_QUERY ="from classModel";
			Query query = session.createQuery(SQL_QUERY);
			List list = query.list();
                        return list;

    }

    @Override
    public classModel getClassById(String classuniquekey) {
      return getSession().get(classModel.class, classuniquekey);
    }

    @Override
    public studentModel getStudentById(int studentid) {
        return getSession().get(studentModel.class,studentid);
    }

    @Override
    public List<sectionModel> getSection() {
                        Session session = sessionFactory.openSession();
			//Query using Hibernate Query Language
			String SQL_QUERY ="from sectionModel";
			Query query = session.createQuery(SQL_QUERY);
			List list = query.list();
                        return list;
    }

    @Override
    public sectionModel getSectionById(int sUniqueKey) {
        return getSession().get(sectionModel.class, sUniqueKey);
    }

    @Override
    public List<studentModel> getStudentByClassSection(String classid, String sectionId) {
        Session session = sessionFactory.openSession();
                    String SQL_QUERY ="from studentModel where studentAvailable='1' and classes_classUniqueKey='"+classid+ "' and section_sectionUniqueKey='"+sectionId+"'";
			Query query = session.createQuery(SQL_QUERY);
			
                        List<studentModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
			}
                       return null;
    }

    @Override
    public void addTeachingStaff(teachingstaffModel teachingstaffmodel) {
        getSession().saveOrUpdate(teachingstaffmodel);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<subjectModel> getSubject() {
       String SQL_QUERY ="from subjectModel";
			Query query = getSession().createQuery(SQL_QUERY);
			
                        List<subjectModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
			}
                       return null;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<feeModel> getFeeDetails() {
        String SQL_QUERY ="from feeModel";
			Query query = getSession().createQuery(SQL_QUERY);
			
                        List<feeModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
			}
                       return null;
        
    }

    @Override
    public List<transportationModel> getTransportationDetails() {
        return (List<transportationModel>)getSession().createCriteria(transportationModel.class).list();
    }

    @Override
    public transportationModel getTrannsportationById(int transportId) {
        return (transportationModel)getSession().get(transportationModel.class, transportId);
    }

    @Override
    public void deleteTransportation(transportationModel transportationinfo) {
        Object persistentInstance = getSession().load(transportationModel.class, transportationinfo.transportationId);
        if (persistentInstance != null) {
          getSession().delete(persistentInstance);
       }
    }

    @Override
    public teachingstaffModel getTeachingStaffById(int teachingstaffId) {
        return (teachingstaffModel)getSession().get(teachingstaffModel.class, teachingstaffId);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public subjectModel getSubjectById(int subjectId) {
        return (subjectModel)getSession().get(subjectModel.class, subjectId);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<galleryModel> getGallery() {
        // Session session = sessionFactory.openSession();
        String SQL_QUERY = "from galleryModel";
        Query query = getSession().createQuery(SQL_QUERY);
	List<galleryModel> list = query.list();		
        if ((list != null) && (list.size() > 0)) {
            return list;
	}
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addGalleryInfo(galleryModel gallery) {
        getSession().saveOrUpdate(gallery);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public galleryModel getGalleryById(int galleryid) {
        return (galleryModel)getSession().get(galleryModel.class, galleryid);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<subjectModel> getSubjectByClass(String classid) {
        Session session = sessionFactory.openSession();
        String SQL_QUERY = "from subjectModel where classes_classUniqueKey='"+classid+ "'";
        Query query = session.createQuery(SQL_QUERY);
	List<subjectModel> list = query.list();		
        if ((list != null) && (list.size() > 0)) {
            return list;
	}
        return null;
    }

    @Override
    public void deleteSubject(subjectModel subjectinfo) {
        Object persistentInstance = getSession().load(subjectModel.class, subjectinfo.subjectId);
        if (persistentInstance != null) {
          getSession().delete(persistentInstance);
       }
    }

    @Override
    public void deleteStudent(studentModel studentinfo) {
        		String SQL_QUERY_marksheet ="Delete FROM markSheet where student.studentId=?";
			Query query_marksheet = getSession().createQuery(SQL_QUERY_marksheet);
                        query_marksheet.setParameter(0,studentinfo.studentId);
			query_marksheet.executeUpdate();
			String SQL_QUERY ="Delete FROM studentModel where studentId=?";
			Query query = getSession().createQuery(SQL_QUERY);
                        query.setParameter(0,studentinfo.studentId);
			query.executeUpdate();
                        
			}

    @Override
    public feeModel getFeeById(int feeId) {
        return getSession().get(feeModel.class, feeId);
    }

    @Override
    public void deleteFee(feeModel feeinfo) {
        Object persistentInstance = getSession().load(feeModel.class, feeinfo.feeId);
        if (persistentInstance != null) {
          getSession().delete(persistentInstance);
       }
    }

    @Override
    public List<staffModel> getStaffByRole(String role) {
        Session session = sessionFactory.openSession();
        String SQL_QUERY = "from staffModel where role='"+role+ "'";
        Query query = session.createQuery(SQL_QUERY);
	List<staffModel> list = query.list();		
        if ((list != null) && (list.size() > 0)) {
            return list;
	}
        return null;
    }
    
    @Override
    public staffModel getStaffById(int staffId) {
        return (staffModel)getSession().get(staffModel.class, staffId);
    }

    @Override
    public void deleteStaff(staffModel staffinfo) {
        Session session = sessionFactory.openSession();
			//Query using Hibernate Query Language
			String SQL_QUERY ="Update staffModel SET staffAvailable=0 where staffId=?";
			Query query = session.createQuery(SQL_QUERY);
                        query.setParameter(0,staffinfo.staffId);
			query.executeUpdate();
       }

    @Override
    public List<teachingstaffModel> getTeachingStaff() {
       return (List<teachingstaffModel>)getSession().createCriteria(teachingstaffModel.class).list();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTeachingStaff(teachingstaffModel staffinfo) {
        String SQL_QUERY ="Delete from teachingstaffModel WHERE teachingstaffId='"+staffinfo.teachingstaffId+ "'";
	Query query = getSession().createQuery(SQL_QUERY);
        query.executeUpdate();
    }

    @Override
    public void addImages(imageModel image) {
       getSession().saveOrUpdate(image);
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public imageModel getImageById(int imageid) {
        return (imageModel)getSession().get(imageModel.class, imageid); 
    }

    @Override
    public void addEvent(eventModel event) {
       getSession().saveOrUpdate(event);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<feedbackModel> getfeedback() {

        return (List<feedbackModel>)getSession().createCriteria(feedbackModel.class).list();

    }

    @Override
    public void updateViewedFeedback(int feedbackId) {
        Session session = sessionFactory.openSession();
			//Query using Hibernate Query Language
			String SQL_QUERY ="Update feedbackModel SET viewed=0 where feedbackId=?";
			Query query = session.createQuery(SQL_QUERY);
                        query.setParameter(0,feedbackId);
			query.executeUpdate();
    }

    @Override
    public String checkIfFeeForClassExists(String classfee) {
        Session session = sessionFactory.openSession();
                       String SQL_QUERY ="from feeModel where classfee="+classfee;
			Query query = session.createQuery(SQL_QUERY);
			
                        List<feeModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return "exist";
                        }
			session.close();
			return "doesntexist" ;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String, Integer> getSchoolInfo() {
          int totalstudent = ((Long)getSession().createQuery("select count(*) from studentModel where studentAvailable=1").uniqueResult()).intValue();
          int totalTeacher = ((Long)getSession().createQuery("select count(*) from teachingstaffModel where availability=1").uniqueResult()).intValue();
          int otherstaff = ((Long)getSession().createQuery("select count(*) from staffModel where staffAvailable=1").uniqueResult()).intValue();
          int newmessage = ((Long)getSession().createQuery("select count(*) from feedbackModel where viewed=1").uniqueResult()).intValue(); 
          HashMap<String,Integer> map=new HashMap<String, Integer>();
          map.put("totalstudent",totalstudent);
          map.put("totalteacher",totalTeacher);
          map.put("otherstaff",otherstaff);
          map.put("newmessage",newmessage);
          return map;
    }

    @Override
    public void addAdmin(adminModel admin) {
        getSession().saveOrUpdate(admin);
    }

    @Override
    public List<eventModel> getEventByMonth(String month) {
                        String SQL_QUERY ="from eventModel where startmonth='"+month+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<eventModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			getSession().close();
			return null ; 

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getStudent() {
                        String SQL_QUERY ="select email from studentModel";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<String> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			getSession().close();
			return null ; 
    }

    @Override
    public List<String> getStudentEmailByClass(int integer) {
                        String SQL_QUERY ="select email from studentModel WHERE classes_classUniqueKey='"+integer+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<String> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			
			return null ; 
    }

    @Override
    public List<studentModel> getStudentBirthday() {
       Session session = sessionFactory.openSession();
                       String SQL_QUERY ="FROM studentModel WHERE DAY(studentDateofbirth)=DAY(CURDATE()) AND MONTH(studentDateofbirth)= MONTH(CURDATE()) AND studentAvailable=1 ";
			Query query = session.createQuery(SQL_QUERY);
			
                        List<studentModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			session.close();
			return null ;
    }

    @Override
    public List<sectionModel> getSectionByClassId(String classuniquekey) {
       String SQL_QUERY ="SELECT sectionUniqueKey,section from sectionModel WHERE classes.classUniqueKey='"+classuniquekey+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<sectionModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			
			return null; 
    }

    @Override
    public void addStudentMarksheet(markSheet mark) {
       getSession().saveOrUpdate(mark);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<markSheet> getMarkByClassSection(String classid, String sectionsid) {
       String SQL_QUERY ="from markSheet WHERE student.classes.classUniqueKey='"+classid+ "'AND student.section.sectionUniqueKey='"+sectionsid+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<markSheet> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			
			return null ; 

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<markSheet> getMarkByStudentId(int std) {
                  String SQL_QUERY ="from markSheet WHERE student.studentId='"+std+"'";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<markSheet> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			
			return null ; 
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

    @Override
    public void deleteMarksheet(int studentid) {
       String SQL_QUERY ="Delete from markSheet WHERE student.studentId='"+studentid+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        query.executeUpdate();

        }

    @Override
    public void deleteAllMarkSheet() {
        String SQL_QUERY ="Delete from markSheet";
			Query query = getSession().createQuery(SQL_QUERY);
                        query.executeUpdate();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<sectionModel> getSectionByClassUniqueKey(String classuniquekey) {
                String SQL_QUERY ="from sectionModel WHERE classes.classUniqueKey='"+classuniquekey+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        List<sectionModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
                        }
			
			return null ; 
    }        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    @Override
    public String deletesection(int sectionid) {
        try{
        String SQL_QUERY ="Delete from sectionModel WHERE sectionUniqueKey='"+sectionid+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        query.executeUpdate();
                        return "sucess";
        }
        catch(Exception e){
            return "fail";
        }
        }
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    @Override
    public void setActivation(int adminid) {
        String SQL_QUERY ="Update adminModel SET activated=0 WHERE adminId='"+adminid+ "'";
			Query query = getSession().createQuery(SQL_QUERY);
                        query.executeUpdate();
    }

    @Override
    public List<studentModel> getStudentByClass(String classid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session session = sessionFactory.openSession();
                    String SQL_QUERY ="from studentModel where studentAvailable='1' and classes_classUniqueKey='"+classid+ "'";
			Query query = session.createQuery(SQL_QUERY);
			
                        List<studentModel> list = query.list();
                        if ((list != null) && (list.size() > 0)) {
                               return list;
			}
                       return null;
    
    }

    @Override
    public markSheet getMarkSheetById(int marksheetid) {
    return (markSheet)getSession().get(markSheet.class, marksheetid);    
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String DeleteClasses(String classuniquekey) {
        try {
        String SQL_QUERY4 ="Delete from subjectModel WHERE classes.classUniqueKey='"+classuniquekey+ "'";
	Query query4 = getSession().createQuery(SQL_QUERY4);
        query4.executeUpdate();
        String SQL_QUERY ="Delete from sectionModel WHERE classes.classUniqueKey='"+classuniquekey+ "'";
	Query query = getSession().createQuery(SQL_QUERY);
        query.executeUpdate();
        String SQL_QUERY3 ="Delete from feeModel WHERE classes.classUniqueKey='"+classuniquekey+ "'";
	Query query3 = getSession().createQuery(SQL_QUERY3);
        query3.executeUpdate();
        String SQL_QUERY1 ="Delete from classModel WHERE classUniqueKey='"+classuniquekey+ "'";
        Query query1 = getSession().createQuery(SQL_QUERY1);
        query1.executeUpdate();
        return "success";
        } catch (Exception e) {
        return "fail";
        }
        
        
    }
    }
    
    
                         
       
    

