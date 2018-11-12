/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.model.classModel;
import com.sms.model.feeModel;
import com.sms.model.feedbackModel;
import com.sms.model.galleryModel;
import com.sms.model.markSheet;
import com.sms.model.sectionModel;
import com.sms.model.staffModel;
import com.sms.model.studentModel;
import com.sms.model.subjectModel;
import com.sms.model.teachingstaffModel;
import com.sms.model.transportationModel;
import com.sms.services.adminServices;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nabish
 */
@Controller
public class adminViewController {
    @Autowired
    adminServices adminservices;
    
    @RequestMapping("/viewdashboard")
    public ModelAndView viewDashBoardController(HttpSession httpSession){
        if(httpSession.getAttribute("adminlogged")!=null){
        HashMap<String, Integer> map=adminservices.getSchoolInfo(); 
        map.put("totalstudent",map.get("totalstudent"));
        map.put("totalteacher",map.get("totalteacher"));
        map.put("otherstaff",map.get("otherstaff"));
        map.put("newmessage",map.get("newmessage"));
         List<studentModel> sbirthday=adminservices.getStudentBirthday();
        HashMap<String,Object> map1=new HashMap<String, Object>();
        map1.put("sbirthday",sbirthday);
        map1.putAll(map);
        return new ModelAndView("admindashboard",map1);
        }
         else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    
     @RequestMapping("/viewstudent")
    public ModelAndView viewStudentController(HttpSession httpSession){
        if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model = new ModelAndView("studentview");
         classModel classList = new classModel();
         List<classModel> getclass = adminservices.getClasses();
         List<sectionModel> getsection = adminservices.getSection();
         model.addObject("classModel",classList);
         model.addObject("sections",getsection);
         model.addObject("classes",getclass);
        return model;
    }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value="/viewstudentlist" , method=RequestMethod.GET)
    public ModelAndView viewStudentListController(HttpSession httpsession, @RequestParam(value = "classid") String classid, @RequestParam(value = "sectionsid") String sectionsid){
       if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model = new ModelAndView("studentview");
          List<classModel> getclass = adminservices.getClasses();
         List<sectionModel> getsection = adminservices.getSection();
         model.addObject("classes",getclass);
         model.addObject("sections",getsection);
       List<studentModel> studentlist=adminservices.getStudentByClassSection(classid,sectionsid);
       model.addObject("studentlist",studentlist);
       return model;
       }else{
          return new ModelAndView("redirect:/restrictpage");
         }
       
    }
    @RequestMapping(value="classview",method = RequestMethod.GET)
    public ModelAndView viewClass(HttpSession httpsession){
        if(httpsession.getAttribute("adminlogged")!=null){
        List<classModel> classdetails = adminservices.getClasses();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("classes", classdetails);
        return new ModelAndView("viewclass",map);
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value="subjectview",method = RequestMethod.GET)
    public ModelAndView viewSubject(HttpSession httpsession){
        if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("viewsubject");
        List<classModel> getclass = adminservices.getClasses();
        model.addObject("classes",getclass);
        return model;
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value="viewsubjectlist" , method=RequestMethod.GET)
    public ModelAndView viewSubjectListController(HttpSession httpsession, @RequestParam(value = "classid") String classid){
        if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model = new ModelAndView("viewsubject");
        List<classModel> getclass = adminservices.getClasses();
        model.addObject("classes",getclass);
       List<subjectModel> subjectlist=adminservices.getSubjectByClass(classid);
       classModel classdata=adminservices.getClassById(classid);
       model.addObject("subjectlists",subjectlist);
       model.addObject("classname",classdata.className);
       return model;
       }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value="galleryview",method = RequestMethod.GET)
    public ModelAndView viewGallery(HttpSession httpsession){
        if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("viewgallery");
        return model;
         }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    @RequestMapping(value="feeview",method = RequestMethod.GET)
    public ModelAndView viewFee(HttpSession httpsession){
        if(httpsession.getAttribute("adminlogged")!=null){
        List<feeModel> feedetails = adminservices.getFeeDetails();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fee", feedetails);
        return new ModelAndView("viewfee",map);
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
        @ResponseBody
        @RequestMapping(value = "studentdetail" , method = RequestMethod.GET)
        public ModelAndView studentDetail(HttpSession httpsession,@RequestParam(value="id") int sid, HttpServletRequest httpServletRequest){
       if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("studentview2");
        studentModel studentdetail = adminservices.getStudentById(sid);
        model.addObject("studentDetail",studentdetail);
        return model;
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
        
       @RequestMapping(value = "transportationview" , method = RequestMethod.GET)
    public ModelAndView viewTransportation(HttpSession httpsession){
              if(httpsession.getAttribute("adminlogged")!=null){

        List<transportationModel> transportationdetails = adminservices.getTransportationDetails();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("bus", transportationdetails);
        return new ModelAndView("viewtransportation",map);
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    
    @RequestMapping(value="viewstaff" , method=RequestMethod.GET)
    public ModelAndView viewStaff(HttpSession httpsession, @RequestParam(value = "role") String role){
        if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model = new ModelAndView("viewstaff");
       List<staffModel> stafflist=adminservices.getStaffByRole(role); 
       model.addObject("staff",stafflist);
        if(role.equals("Accountant")){
            model.addObject("role","Accountant");
        }
        if(role.equals("Librarian")){
            model.addObject("role","Librarian");
        }     
       return model;
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    @RequestMapping(value="staffview", method = RequestMethod.GET)
    public ModelAndView viewStaffDashBoard(HttpSession httpsession){
        if(httpsession.getAttribute("adminlogged")!=null){
        return new ModelAndView("viewstaff");
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
     @RequestMapping(value="viewteachingstaff" , method=RequestMethod.GET)
    public ModelAndView viewTeachingStaff(HttpSession httpsession){
               if(httpsession.getAttribute("adminlogged")!=null){

       ModelAndView model = new ModelAndView("viewstaff");
       List<teachingstaffModel> teachers=adminservices.getTeachingStaff();
       model.addObject("staff",teachers);
       model.addObject("role","Teacher");
       return model;
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value="schoolgalleryalbumbs" , method=RequestMethod.GET)
    public ModelAndView viewnkkn(HttpSession httpsession){
         if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("viewgallery");
        List<galleryModel> galleryname=adminservices.getGallery();
        model.addObject("galleryname",galleryname);
        return model;
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value="viewfeedback",method = RequestMethod.GET)
    public ModelAndView viewFeedbackController(HttpSession httpsession){
       if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("viewfeedback");
        List<feedbackModel> feedbacklist=adminservices.getfeedback();
        model.addObject("feedback",feedbacklist);
        return model;
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }

    @RequestMapping(value="viewedfeedback" , method=RequestMethod.GET)
    public ModelAndView viewedFeedbackController(HttpSession httpsession,@RequestParam(value = "feedbackid") int feedbackId){
       if(httpsession.getAttribute("adminlogged")!=null){
        adminservices.updateViewedFeedback(feedbackId);
        return new ModelAndView("redirect:/viewfeedback");
       }else{
          return new ModelAndView("redirect:/restrictpage");
         }         
    }
    @RequestMapping(value="viewmarksheet" , method=RequestMethod.GET)
    public ModelAndView viewedMarksheetController(HttpSession httpsession){
       if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("viewmarksheet");
        List<classModel> getclass = adminservices.getClasses();
        List<sectionModel> getsection = adminservices.getSection();
        model.addObject("classes",getclass);
        model.addObject("sections",getsection);
        return model; 
        }else{
          return new ModelAndView("redirect:/restrictpage");
         }    
    }
    
        @RequestMapping(value = "dashboardmarksheet",method = RequestMethod.POST)
        public ModelAndView viewStudentMarksheet(HttpServletRequest request,HttpSession httpsession, @RequestParam(value = "classid") String classid, @RequestParam(value="sectionsid") String sectionsid){
            if(httpsession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("viewmarksheet2");
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classid, sectionsid);
            model.addObject("student",studentlist);
            return model;
             }else{
          return new ModelAndView("redirect:/restrictpage");
         }    
        }
        
        @RequestMapping(value = "adminviewmarksheet", method = RequestMethod.GET)
        public ModelAndView adminviewmarksheet(HttpSession httpsession,@RequestParam(value = "studentId") int std, @RequestParam(value="classId") String classId,@RequestParam(value="sectionId") String sectionId){
            if(httpsession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("viewmarksheet3");
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classId,sectionId);          
            List<markSheet> stdmark=adminservices.getMarkByStudentId(std);
            studentModel studentinfo=adminservices.getStudentById(std);
            model.addObject("studentinfo", studentinfo);
            model.addObject("students",studentlist);
            model.addObject("markSheet",stdmark);
            return model;
            }else{
          return new ModelAndView("redirect:/restrictpage");
         }    
        }
        
        @RequestMapping(value = "printclassinfo",method = RequestMethod.POST)
        public ModelAndView printMarksheetView(HttpServletRequest request,HttpSession httpsession, @RequestParam(value = "classid") String classid){
                        if(httpsession.getAttribute("adminlogged")!=null){

            ModelAndView model=new ModelAndView("printmarksheet2");
            List<studentModel> studentlist=adminservices.getStudentByClass(classid);
            
            for(studentModel std:studentlist){
                int totalmark=0;
                int totalsub=0;
                String result="";
                String division="";
             for(markSheet s:std.marksheet){
                    totalmark=totalmark+s.total;
                    totalsub++;
                    
                    float percentage=totalmark/totalsub;
                    if(percentage>=80){
                        division="Distinction";
                    }
                    else if(percentage>=60 && percentage<80){
                        division="first";
                    }
                    else if(percentage>=50 && percentage<60){
                        division="Second";
                    }
                    else if(percentage>=40 && percentage<50){
                        division="Third";
                    }
                    else{
                        division="Fail";
                    } 
                    
                    std.setDivision(division);
                    std.setPercentage(percentage);
                    std.setGrandtotal(totalmark);
                    std.setResult(result);
             }
             int marksObtainedPratical;
             int marksObtained;
             for(markSheet s:std.marksheet){
                 
                 if("abs".equals(s.marksObtainedPratical)){
                    marksObtainedPratical=0;  
                 }else{
                 marksObtainedPratical=Integer.parseInt(s.marksObtainedPratical);
                 }
                 int practicalPassMark=Integer.parseInt(s.practicalPassMark);
                 if("abs".equals(s.marksObtained)){
                     marksObtained=0;
                 }
                 else{
                 marksObtained=Integer.parseInt(s.marksObtained);
                 }
                 int theoryPassMark=Integer.parseInt(s.theoryPassMark);
                 
                    if(marksObtainedPratical<practicalPassMark||marksObtained<theoryPassMark){
                        result= "fail";
                        break;
                    }
                    if(marksObtainedPratical>practicalPassMark&&marksObtained>theoryPassMark){
                        result="pass";
                    }
                   
             }
                  std.setResult(result);               
            }
            TreeMap<Integer,Object> hm=new TreeMap<Integer,Object>(); 
           for(studentModel std:studentlist){
               hm.put(std.getGrandtotal(), std);
               
           }
           Map<Integer,Object> map = new TreeMap(Collections.reverseOrder());
                map.putAll(hm);

            model.addObject("students",map.values());
            return model;
            }else{
          return new ModelAndView("redirect:/restrictpage");
         }    
        }     
    
         @RequestMapping(value = "billingclassinfo",method = RequestMethod.POST)
        public ModelAndView printBillingView(HttpServletRequest request,HttpSession httpSession, @RequestParam(value = "classid") String classid, @RequestParam(value="sectionsid") String sectionsid){
           if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("billing2");
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classid,sectionsid);
            int count=0; 
            for (studentModel std : studentlist) {
                 count++;
             }
            classModel classes = adminservices.getClassById(classid);
            feeModel fee = adminservices.getFeeById(classes.fees.feeId);
            model.addObject("fee",fee);
            model.addObject("students",studentlist);
            model.addObject("studentcount",count);
            return model;
           }else{
          return new ModelAndView("redirect:/restrictpage");
         }

        }
        
        @RequestMapping(value ="sectionview", method=RequestMethod.GET)
        public ModelAndView viewSection(HttpSession httpsession){
        if(httpsession.getAttribute("adminlogged")!=null){
        ModelAndView model = new ModelAndView("viewsection");
        List<classModel> getclass = adminservices.getClasses();
        model.addObject("classes",getclass);
        return model; 
        }
                 else{
          return new ModelAndView("redirect:/restrictpage");
         }

        }
        
        @RequestMapping(value = "viewsectionlist", method = RequestMethod.GET)
        public ModelAndView viewSectionList(HttpSession httpsession,@RequestParam (value="classid") String classuniquekey){
            if(httpsession.getAttribute("adminlogged")!=null){
            ModelAndView model = new ModelAndView("viewsection");
                List<classModel> getclass = adminservices.getClasses();
                model.addObject("classes",getclass);
                List<sectionModel> section=adminservices.getSectionByClassUniqueKey(classuniquekey);
                classModel classdata=adminservices.getClassById(classuniquekey);
                model.addObject("classname",classdata.className);
                model.addObject("sectionlists",section);
                model.addObject("classes",getclass);
                return model;
                }
                 else{
          return new ModelAndView("redirect:/restrictpage");
         }
        }
        @RequestMapping(value = "viewmarksheetfromstudent", method = RequestMethod.GET)
        public ModelAndView viewMarksheetFromStudent(HttpSession httpsession,@RequestParam (value="sid") int studentid){
           if(httpsession.getAttribute("adminlogged")!=null){  
            ModelAndView model=new ModelAndView("viewmarksheet3");
             studentModel std=adminservices.getStudentById(studentid);
             String classId=std.classes.classUniqueKey;
              String sectionId=Integer.toString(std.section.sectionUniqueKey);
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classId,sectionId);          
            List<markSheet> stdmark=adminservices.getMarkByStudentId(studentid);
            studentModel studentinfo=adminservices.getStudentById(studentid);
            model.addObject("studentinfo", studentinfo);
            model.addObject("students",studentlist);
            model.addObject("markSheet",stdmark);
            return model;
            }
                 else{
          return new ModelAndView("redirect:/restrictpage");
         }
        }
        
@RequestMapping(value = "admitcardclassinfo",method = RequestMethod.POST)
        public ModelAndView printAdmitCard(HttpServletRequest request,HttpSession httpsession, @RequestParam(value = "classid") String classid, @RequestParam(value="sectionsid") String sectionsid){
           if(httpsession.getAttribute("adminlogged")!=null){  
            ModelAndView model=new ModelAndView("admitcard");
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classid,sectionsid);
            classModel classes = adminservices.getClassById(classid);
            model.addObject("students",studentlist);
            model.addObject("classes",classes);
            return model;
            }
                 else{
          return new ModelAndView("redirect:/restrictpage");
         }
        }
}
