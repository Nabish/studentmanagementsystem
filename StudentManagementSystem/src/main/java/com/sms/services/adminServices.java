/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.services;

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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author nabish
 */
public interface adminServices {

   
    public adminModel adminLogin(adminModel admin);
    public void addClass(classModel classmodel);
    public void addStaff(staffModel staffmodel);
    public void addSubject(subjectModel subject);
    public void addFee(feeModel fee);
    public void addStudent(studentModel studentinfo);
    public void addTransportation(transportationModel transportationinfo);
    public void addSection(sectionModel section);
    public List<classModel> getClasses();
    public List<sectionModel> getSection();
    public List<subjectModel> getSubject();
    public List<galleryModel> getGallery();
    public List<teachingstaffModel> getTeachingStaff();
    public void addGalleryInfo(galleryModel gallery);
    public void addTeachingStaff(teachingstaffModel teachingstaffmodel);
    public classModel getClassById(String classuniquekey);
    public studentModel getStudentById(int studentid);
    public sectionModel getSectionById(int sUniqueKey);
    public List<studentModel> getStudentByClassSection(String classid,String sectionId);

    public List<feeModel> getFeeDetails();

    public List<transportationModel> getTransportationDetails();

    public transportationModel getTrannsportationById(int transportId);

    public void deleteTransportation(transportationModel transportationinfo);
    public teachingstaffModel getTeachingStaffById(int teachingstaffId);
    public subjectModel getSubjectById(int subjectId);
    public galleryModel getGalleryById(int galleryid);

    public List<subjectModel> getSubjectByClass(String classid);

    public void deleteSubject(subjectModel subjectinfo);

    public void deleteStudent(studentModel studentinfo);

    public feeModel getFeeById(int feeId);

    public void deleteFee(feeModel feeinfo);

    public List<staffModel> getStaffByRole(String role);

    public staffModel getStaffById(int staffId);
    public imageModel getImageById(int imageid);
    public void deleteStaff(staffModel staffinfo);
    public void deleteTeachingStaff(teachingstaffModel staffinfo);
    public void addImages(imageModel image);
    public void addEvent(eventModel event);

    public List<feedbackModel> getfeedback();

    public void updateViewedFeedback(int feedbackId);

    public String checkIfFeeForClassExists(String classfee);

    public HashMap<String, Integer> getSchoolInfo();

    public void addAdmin(adminModel admin);

    public List<eventModel> getEventByMonth(String month);

    public List<String> getStudent();

    public List<String> getStudentEmailByClass(int integer);

    public List<studentModel> getStudentBirthday();

    public List<sectionModel> getSectionByClassId(String classuniquekey);

    public void addStudentMarksheet(markSheet mark);

    public List<markSheet> getMarkByClassSection(String classid, String sectionsid);

    public List<markSheet> getMarkByStudentId(int std);

    public List<markSheet> getStudentMarksheetById(int studentId);

    public void deleteMarksheet(int studentid);

    public void deleteAllMarkSheet();

    public List<sectionModel> getSectionByClassUniqueKey(String classuniquekey);

    public String deletesection(int sectionid);

    public void setActivation(int adminid);

    public List<studentModel> getStudentByClass(String classid);

    public markSheet getMarkSheetById(int marksheetid);

    public String DeleteClasses(String classuniquekey);


     
}
