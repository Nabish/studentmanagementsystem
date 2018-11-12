/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services.servicesimpl;

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
import com.sms.services.adminServices;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author nabish
 */
@Service("adminservices")
@Transactional
public class adminServicesImpl implements adminServices{

    @Autowired
    adminDao admindao;
    
    @Override
    public adminModel adminLogin(adminModel adminData) {
       return admindao.adminLogin(adminData);
    }

    @Override
    public void addClass(classModel classmodel) {
        admindao.addClass(classmodel);
    }

    @Override
    public void addStaff(staffModel staffmodel) {
        admindao.addStaff(staffmodel);
    }

    @Override
    public void addSubject(subjectModel subject) {
        admindao.addSubject(subject);
    }

    @Override
    public void addFee(feeModel fee) {
        admindao.addFee(fee);
    }
    
        @Override
    public void addStudent(studentModel studentinfo) {
        admindao.addStudent(studentinfo);
    }
    
    @Override
    public void addTransportation(transportationModel transportationinfo) {
        admindao.addTransportation(transportationinfo);    
                
                }

    @Override
    public void addSection(sectionModel section) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        admindao.addSection(section);
    }

    @Override
    public List<classModel> getClasses() {
       return admindao.getClasses();
    }

    @Override
    public classModel getClassById(String classuniquekey) {
        return admindao.getClassById(classuniquekey);
    }

    @Override
    public studentModel getStudentById(int studentid) {
        return admindao.getStudentById(studentid);
    }

    @Override
    public List<sectionModel> getSection() {
        return admindao.getSection();
    }

    @Override
    public sectionModel getSectionById(int sUniqueKey) {
        return admindao.getSectionById(sUniqueKey);
    }

    @Override
    public List<studentModel> getStudentByClassSection(String classid, String sectionid) {
        return admindao.getStudentByClassSection(classid,sectionid);
    }

    @Override
    public void addTeachingStaff(teachingstaffModel teachingstaffmodel) {
        admindao.addTeachingStaff(teachingstaffmodel);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<subjectModel> getSubject() {
        return admindao.getSubject();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<feeModel> getFeeDetails() {
        return admindao.getFeeDetails();
    }

    @Override
    public List<transportationModel> getTransportationDetails() {
        return admindao.getTransportationDetails();
    }

    @Override
    public transportationModel getTrannsportationById(int transportId) {
        return admindao.getTrannsportationById(transportId);
    }

    @Override
    public void deleteTransportation(transportationModel transportationinfo) {
        admindao.deleteTransportation(transportationinfo);
    }
    
@Override
    public teachingstaffModel getTeachingStaffById(int teachingstaffId) {
        return admindao.getTeachingStaffById(teachingstaffId);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public subjectModel getSubjectById(int subjectId) {
        return admindao.getSubjectById(subjectId);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<galleryModel> getGallery() {
        return admindao.getGallery();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addGalleryInfo(galleryModel gallery) {
        admindao.addGalleryInfo(gallery);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public galleryModel getGalleryById(int galleryid) {
        return admindao.getGalleryById(galleryid);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<subjectModel> getSubjectByClass(String classid) {
        return admindao.getSubjectByClass(classid);
    }

    @Override
    public void deleteSubject(subjectModel subjectinfo) {
        admindao.deleteSubject(subjectinfo);
    }

    @Override
    public void deleteStudent(studentModel studentinfo) {
        admindao.deleteStudent(studentinfo);
    }

    @Override
    public feeModel getFeeById(int feeId) {
        return admindao.getFeeById(feeId);
    }

    @Override
    public void deleteFee(feeModel feeinfo) {
        admindao.deleteFee(feeinfo);
    }

    @Override
    public List<staffModel> getStaffByRole(String role) {
        return admindao.getStaffByRole(role);
    }

    @Override
    public staffModel getStaffById(int staffId) {
        return admindao.getStaffById(staffId);
    }

    @Override
    public void deleteStaff(staffModel staffinfo) {
        admindao.deleteStaff(staffinfo);
    }

    @Override
    public List<teachingstaffModel> getTeachingStaff() {
        return admindao.getTeachingStaff();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTeachingStaff(teachingstaffModel staffinfo) {
        admindao.deleteTeachingStaff(staffinfo);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addImages(imageModel image) {
        admindao.addImages(image);
    }

    @Override
    public imageModel getImageById(int imageid) {
        return admindao.getImageById(imageid);
    }

    @Override
    public void addEvent(eventModel event) {
        admindao.addEvent(event);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<feedbackModel> getfeedback() {
        return admindao.getfeedback();
    }

    @Override
    public void updateViewedFeedback(int feedbackId) {
        admindao.updateViewedFeedback(feedbackId);
    }

    @Override
    public String checkIfFeeForClassExists(String classfee) {
     return  admindao.checkIfFeeForClassExists(classfee);
    }

    @Override
    public HashMap<String, Integer> getSchoolInfo() {
        return admindao.getSchoolInfo();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAdmin(adminModel admin) {
        admindao.addAdmin(admin);
    }

    @Override
    public List<eventModel> getEventByMonth(String month) {
        
        return admindao.getEventByMonth(month);//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getStudent() {
       return admindao.getStudent();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getStudentEmailByClass(int integer) {
       return admindao.getStudentEmailByClass(integer);// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<studentModel> getStudentBirthday() {
       return admindao.getStudentBirthday();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<sectionModel> getSectionByClassId(String classuniquekey) {
        return admindao.getSectionByClassId(classuniquekey);
    }

    @Override
    public void addStudentMarksheet(markSheet mark) {
        admindao.addStudentMarksheet(mark);
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<markSheet> getMarkByClassSection(String classid, String sectionsid) {
        return admindao.getMarkByClassSection(classid,sectionsid);
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<markSheet> getMarkByStudentId(int std) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return admindao.getMarkByStudentId(std);
    }

    @Override
    public List<markSheet> getStudentMarksheetById(int studentId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return admindao.getStudentMarksheetById(studentId);
    }

    @Override
    public void deleteMarksheet(int studentid) {
       admindao.deleteMarksheet(studentid);
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAllMarkSheet() {
        admindao.deleteAllMarkSheet();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<sectionModel> getSectionByClassUniqueKey(String classuniquekey) {
       return admindao.getSectionByClassUniqueKey(classuniquekey);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deletesection(int sectionid) {
       return admindao.deletesection(sectionid);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActivation(int adminid) {
        admindao.setActivation(adminid);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<studentModel> getStudentByClass(String classid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return admindao.getStudentByClass(classid);
    }

    @Override
    public markSheet getMarkSheetById(int marksheetid) {
      return admindao.getMarkSheetById(marksheetid);
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String DeleteClasses(String classuniquekey) {
       return admindao.DeleteClasses(classuniquekey);
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
