/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.model.adminModel;
import com.sms.model.classModel;
import com.sms.model.eventModel;
import com.sms.model.feeModel;
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
import com.sms.util.FileUploadUtility;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nabish
 */
@Controller
public class adminController {
    @Autowired
    public static MailSender mail;
   
    @Autowired
    adminServices adminservices;
    
    @Autowired
    private MailSender mailSender;

    
    @RequestMapping("adminadddashboard")
    public ModelAndView addDashboardController(HttpSession httpsession){
        if(httpsession.getAttribute("adminlogged")!=null){
        HashMap<String, Integer> map=adminservices.getSchoolInfo(); 
        map.put("totalstudent",map.get("totalstudent"));
        map.put("totalteacher",map.get("totalteacher"));
        map.put("otherstaff",map.get("otherstaff"));
        map.put("newmessage",map.get("newmessage"));
        return new ModelAndView("adminadddashboard",map);
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
        }
    }
    
    @RequestMapping (value = "addstudent" , method = RequestMethod.POST)
    
    public ModelAndView addStudents(HttpSession httpsession,@Valid @ModelAttribute studentModel student,BindingResult result,HttpServletRequest request,RedirectAttributes attributes) throws ServletException, IOException{
        

        if(result.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "Fill all the informations correctly");
            List<classModel> getclass = adminservices.getClasses();
            List<sectionModel> getsection = adminservices.getSection();
            map.put("classList",getclass);
            map.put("sectionList",getsection);
            return new ModelAndView("addstudent", map);
        }
       else{
        try{
        String classuniquekey=student.classes.classUniqueKey;
        classModel classes=adminservices.getClassById(classuniquekey);
        student.setClasses(classes);
        student.studentAvailable=1;
        if(student.transportationFlag==null){
            student.transportationFlag="0";
        }
        String encodedpassword = DatatypeConverter.printBase64Binary(student.getStudentRegistrationNumber().getBytes());
        student.username=student.getStudentRegistrationNumber();
        student.password=encodedpassword;
        student.studentDateofbirth=new SimpleDateFormat("dd/MM/yyyy").parse(student.studentDOB);
        String imagepath=null;
        adminservices.addStudent(student);
        if(!student.getFile().getOriginalFilename().equals("")){
          String code=student.getCode();
          imagepath = FileUploadUtility.uploadFile(request,student.getFile(),code);
          student.setStudentPhoto(imagepath);
        }
       /* SimpleMailMessage message = new SimpleMailMessage();
	message.setFrom("man.nabish.singh@gmail.com");
	message.setTo(student.email);
	message.setSubject("your username and password for Student management system");
	message.setText("username:"+student.studentRegistrationNumber+"  Password:"+student.studentRegistrationNumber);
	mailSender.send(message);*/
        adminservices.addStudent(student); 
        attributes.addFlashAttribute("message", "Student Record has been successfully added");
        return new ModelAndView("redirect:/addstudentform");
        }
       catch(ParseException e){
            System.out.println("error date-----------------------"+e);
        }
            
   }
        attributes.addFlashAttribute("message", "Error");
        return new ModelAndView("redirect:/addstudentform");
    }
    //transportation
        @RequestMapping (value = "addtransportation" , method = RequestMethod.POST)
    public ModelAndView addTransportation(HttpSession httpsession,@Valid @ModelAttribute transportationModel transportation,BindingResult result,HttpServletRequest request) throws ServletException, IOException{
        HashMap<String,Object> map=new HashMap<String, Object>();
        if (result.hasErrors()) {
            map.put("message", "fill all information");
            return new ModelAndView("addtransportationform",map);
            }
        else{
        adminservices.addTransportation(transportation);
        transportationModel model=new transportationModel();
        map.put("transportationModel",model);
        map.put("message","New transportation has been added");
        return new ModelAndView("addtransportationform",map);
        }
    }
    
    //direct matra garne
    
     @RequestMapping (value = "/addstudentform" , method = RequestMethod.GET)
     public ModelAndView studentForm(HttpSession httpsession){
         if(httpsession.getAttribute("adminlogged")!=null){
         ModelAndView model = new ModelAndView("addstudent");
         studentModel student=new studentModel();
         List<sectionModel> getsection = adminservices.getSection();
         List<classModel> getclass = adminservices.getClasses();
         model.addObject("classList",getclass);
         model.addObject("sectionList",getsection);
         model.addObject("studentModel",student);
         return model;
         }
         else{
          return new ModelAndView("redirect:/restrictpage");
         }
         
     }
     
     @RequestMapping(value = "studentedit" , method = RequestMethod.GET)
    public ModelAndView editStudent(HttpSession httpSession , @RequestParam("id")  int studentId){
        if(httpSession.getAttribute("adminlogged")!=null){
        studentModel studentinfo = adminservices.getStudentById(studentId);
        ModelAndView model=new ModelAndView("addstudent");
        List<classModel> getclass = adminservices.getClasses();
         List<sectionModel> getsection = adminservices.getSection();
         model.addObject("classList",getclass);
         model.addObject("sectionList",getsection);
        model.addObject("studentModel",studentinfo);
        return model;
        }
         else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    
     @RequestMapping(value = "studentdelete" , method = RequestMethod.GET)
    public ModelAndView deleteStudent(HttpSession httpSession , @RequestParam("id")  int studentId,@RequestParam("classId")  String classid,@RequestParam("sectionId")  String sectionid){
        if(httpSession.getAttribute("adminlogged")!=null){
        studentModel studentinfo = adminservices.getStudentById(studentId);
        adminservices.deleteStudent(studentinfo);
        List<studentModel> student=adminservices.getStudentByClassSection(classid, sectionid);
        ModelAndView model=new ModelAndView("studentview");
        List<classModel> getclass = adminservices.getClasses();
         List<sectionModel> getsection = adminservices.getSection();
         model.addObject("sections",getsection);
         model.addObject("classes",getclass);
        model.addObject("studentlist",student);
        return model;
    }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }    
         @RequestMapping (value = "/addtransportationform" , method = RequestMethod.GET)
         public ModelAndView transportationForm(HttpSession httpSession){
         if(httpSession.getAttribute("adminlogged")!=null){
         ModelAndView model = new ModelAndView("addtransportationform");
         transportationModel transportation=new transportationModel();
         model.addObject("transportationModel",transportation);
         return model;
     }
          else{
          return new ModelAndView("redirect:/restrictpage");
         }
         }
     
     @RequestMapping(value = "transportationedit" , method = RequestMethod.GET)
    public ModelAndView editTransportation(HttpSession httpSession , @RequestParam("id")  int transportId){
        if(httpSession.getAttribute("adminlogged")!=null){
        transportationModel transportationinfo = adminservices.getTrannsportationById(transportId);
        ModelAndView model=new ModelAndView("addtransportationform");
        model.addObject("transportationModel",transportationinfo);
        return model;
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
   
    @RequestMapping(value = "transportationdelete" , method = RequestMethod.GET)
    public ModelAndView deleteTransportation(HttpSession httpSession , @RequestParam("id")  int transportId){
        if(httpSession.getAttribute("adminlogged")!=null){
        transportationModel transportationinfo = adminservices.getTrannsportationById(transportId);
        adminservices.deleteTransportation(transportationinfo);
        List<transportationModel> transportationdetails = adminservices.getTransportationDetails();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("bus", transportationdetails);
        return new ModelAndView("viewtransportation",map);
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
     
     
     @RequestMapping(value = "classForm" , method = RequestMethod.GET)
        public ModelAndView classForm(HttpServletRequest request,HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("addClass");
            classModel classes = new classModel();
            model.addObject("classModel",classes);
            List<classModel> classlist=adminservices.getClasses();
            model.addObject("classes",classlist);
            return model;
        }
          else{
          return new ModelAndView("redirect:/restrictpage");
         }
        }
    @RequestMapping(value = "classadd" , method = RequestMethod.POST)
    public ModelAndView addClass(HttpServletRequest request, HttpSession httpSession,@Valid @ModelAttribute classModel addClassform, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "Fill all the informations correctly");
            return new ModelAndView("addClass", map);
        }
        adminservices.addClass(addClassform); 
        ModelAndView model=new ModelAndView("addClass");
        model.addObject("message", "Class added Succesfully");
        classModel classes = new classModel();
        model.addObject("classModel",classes);
        List<classModel> classlist=adminservices.getClasses();
        model.addObject("classes",classlist);
        return model;
    }
    
     @RequestMapping(value = "classedit" , method = RequestMethod.GET)
    public ModelAndView editClass(HttpSession httpSession,  @RequestParam("id")  String classUniqueKey){
        if(httpSession.getAttribute("adminlogged")!=null){
        classModel classinfo = adminservices.getClassById(classUniqueKey);
        ModelAndView model=new ModelAndView("addClass");
        model.addObject("classModel",classinfo);
        return model;
        }
         else{
          return new ModelAndView("redirect:/restrictpage");
         }

        }
    
    @RequestMapping(value = "staffForm" , method = RequestMethod.GET)
    public ModelAndView classForm(HttpSession httpSession, HttpServletRequest httpServletRequest){
        if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("addstaffform");
        staffModel staff = new staffModel();
        model.addObject("staffModel",staff);
        return model;
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value = "staffadd" , method = RequestMethod.POST)
    public ModelAndView addstaff(RedirectAttributes attributes,HttpServletRequest request, HttpSession httpSession,@Valid @ModelAttribute staffModel addStaffForm, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "Fill all the informations correctly");
            return new ModelAndView("addstaffform", map);
        }
        else{
        addStaffForm.staffAvailable=1;
        adminservices.addStaff(addStaffForm); 
        
        ModelAndView model=new ModelAndView("addstaffform");
        staffModel staff = new staffModel();
        model.addObject("staffModel",staff);
        model.addObject("message","New Staff Has been added");
        return model;
        }
    }
    
    @RequestMapping(value = "staffedit" , method = RequestMethod.GET)
    public ModelAndView editStaff(HttpSession httpSession , @RequestParam("id")  int staffId){
        if(httpSession.getAttribute("adminlogged")!=null){
        staffModel staffinfo = adminservices.getStaffById(staffId);
        ModelAndView model=new ModelAndView("addstaffform");
        model.addObject("staffModel",staffinfo);
        return model;
    }
          else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    @RequestMapping(value = "teachingstaffedit" , method = RequestMethod.GET)
    public ModelAndView editTeachingStaff(HttpSession httpSession , @RequestParam("id")  int tstaffId){
        if(httpSession.getAttribute("adminlogged")!=null){
        teachingstaffModel teachingstaffinfo = adminservices.getTeachingStaffById(tstaffId);
        ModelAndView model=new ModelAndView("addteachingstaff");
        List<subjectModel> getsubject = adminservices.getSubject();
        model.addObject("subjects",getsubject);
        model.addObject("teachingstaffModel",teachingstaffinfo);
        return model;
    }
         else{
          return new ModelAndView("redirect:/restrictpage");
         }
      }
    
    
    @RequestMapping(value = "staffdelete" , method = RequestMethod.GET)
    public ModelAndView deleteStaff(HttpSession httpSession , @RequestParam("id")  int staffId){
        if(httpSession.getAttribute("adminlogged")!=null){
        staffModel staffinfo = adminservices.getStaffById(staffId);
        adminservices.deleteStaff(staffinfo);
        return new ModelAndView("viewstaff");
        }
        else{
           return new ModelAndView("redirect:/restrictpage");  
        }
    }
   
    @RequestMapping(value = "teachingstaffdelete" , method = RequestMethod.GET)
    public ModelAndView deleteTeachingStaff(HttpSession httpSession , @RequestParam("id")  int tstaffId){
        if(httpSession.getAttribute("adminlogged")!=null){
        teachingstaffModel teacherstaffinfo = adminservices.getTeachingStaffById(tstaffId);
        adminservices.deleteTeachingStaff(teacherstaffinfo);
        return new ModelAndView("viewstaff");
        }
         else{
           return new ModelAndView("redirect:/restrictpage");  
        }
    }
    
    @RequestMapping(value = "subjectForm" , method = RequestMethod.GET)
        public ModelAndView subjectForm(HttpServletRequest request,HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("addsubject");
            subjectModel subject = new subjectModel();
            List<classModel> getclass = adminservices.getClasses();
            model.addObject("classList",getclass);
            model.addObject("subjectModel",subject);
            return model;
        }
         else{
           return new ModelAndView("redirect:/restrictpage");  
        }   
        }
        
    @RequestMapping(value = "subjectadd" , method = RequestMethod.POST)
    public ModelAndView addClass(HttpServletRequest request, HttpSession httpSession,@Valid @ModelAttribute subjectModel addsubjectform, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "Fill all the informations correctly");
            return new ModelAndView("addsubject", map);
        }
        
        else{
            if(addsubjectform.subjectFlag==null){
            addsubjectform.subjectFlag="0";
            addsubjectform.practicalFullMark="0";
            addsubjectform.practicalPassMark="0";
            }
            
        adminservices.addSubject(addsubjectform); 
        ModelAndView model=new ModelAndView("addsubject");
            subjectModel subject = new subjectModel();
            model.addObject("subjectModel",subject);
            List<classModel> getclass = adminservices.getClasses();
            model.addObject("classList",getclass);
            model.addObject("message","New Subject Has been added");
            return model;
        }
    }
    
    @RequestMapping(value = "subjectedit" , method = RequestMethod.GET)
    public ModelAndView editSubject(HttpSession httpSession,  @RequestParam("id")  int subjectId){
        if(httpSession.getAttribute("adminlogged")!=null){
        subjectModel subjectinfo = adminservices.getSubjectById(subjectId);
        ModelAndView model=new ModelAndView("addsubject");
        List<classModel> getclass = adminservices.getClasses();
            model.addObject("classList",getclass);
        model.addObject("subjectModel",subjectinfo);
        return model;
    }
          else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    
    @RequestMapping(value = "subjectdelete" , method = RequestMethod.GET)
    public ModelAndView deleteSubject(HttpSession httpSession , @RequestParam("id")  int subjectId,@RequestParam("classId")  String classid){
        if(httpSession.getAttribute("adminlogged")!=null){
        subjectModel subjectinfo = adminservices.getSubjectById(subjectId);
        adminservices.deleteSubject(subjectinfo);
         ModelAndView model=new ModelAndView("viewsubject");
         List<subjectModel> sub=adminservices.getSubjectByClass(classid);
        List<classModel> getclass = adminservices.getClasses();
        model.addObject("classes",getclass);
        model.addObject("subjectlists",sub);
        return model;
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value = "feeForm" , method = RequestMethod.GET)
        public ModelAndView feeForm(HttpServletRequest request,HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("addfee");
            feeModel fee = new feeModel();
            List<classModel> getclass = adminservices.getClasses();
            model.addObject("classList",getclass);
            model.addObject("feeModel",fee);
            return model;
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }            
        }
        
    @RequestMapping(value = "feeadd" , method = RequestMethod.POST)
    public ModelAndView addFee(HttpServletRequest request, HttpSession httpSession,@Valid @ModelAttribute feeModel addfeeform, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "Fill all the informations correctly");
            List<classModel> getclass = adminservices.getClasses();
            map.put("classList",getclass);
            return new ModelAndView("addfee", map);
        }
        else{
        String classfee=addfeeform.getClasses().classUniqueKey;
        String feedata=adminservices.checkIfFeeForClassExists(classfee);
        if(feedata.equals("exist")){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "The information for class already exist");
             List<classModel> getclass = adminservices.getClasses();
            map.put("classList",getclass);
            return new ModelAndView("addfee", map);
            
        }
        else{
        adminservices.addFee(addfeeform); 
        ModelAndView model=new ModelAndView("addfee");
        feeModel fee = new feeModel();
        List<classModel> getclass = adminservices.getClasses();
        model.addObject("classList",getclass);
        model.addObject("feeModel",fee);
        model.addObject("message","New Fee Information Has Been Added");
        return model;
        }
            
        }
    }
    
    @RequestMapping(value = "feeedit" , method = RequestMethod.GET)
    public ModelAndView editFee(HttpSession httpSession , @RequestParam("id")  int feeId){
        if(httpSession.getAttribute("adminlogged")!=null){
        feeModel feeinfo = adminservices.getFeeById(feeId);
        ModelAndView model=new ModelAndView("addfee");
        List<classModel> getclass = adminservices.getClasses();
        model.addObject("classList",getclass);
        model.addObject("feeModel",feeinfo);
        return model;
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    
    @RequestMapping(value = "feedelete" , method = RequestMethod.GET)
    public ModelAndView deleteFee(HttpSession httpSession , @RequestParam("id")  int feeId){
        if(httpSession.getAttribute("adminlogged")!=null){
        feeModel feeinfo = adminservices.getFeeById(feeId);
        adminservices.deleteFee(feeinfo);
         List<feeModel> feedetails = adminservices.getFeeDetails();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("fee", feedetails);
        return new ModelAndView("viewfee",map);
    }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    
    @RequestMapping(value = "sectionForm" , method = RequestMethod.GET)
        public ModelAndView sectionForm(HttpServletRequest request,HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("addsection");
            sectionModel section = new sectionModel();
            List<classModel> getclass = adminservices.getClasses();
            model.addObject("classList",getclass);
            model.addObject("sectionModel",section);
            return model;
        }
            else{
          return new ModelAndView("redirect:/restrictpage");
         }
        }
        
    @RequestMapping(value = "sectionadd" , method = RequestMethod.POST)
    public ModelAndView addSection(RedirectAttributes attributes,HttpServletRequest request, HttpSession httpSession,@Valid @ModelAttribute sectionModel addsectionform, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "Fill all the informations correctly");
            List<classModel> getclass = adminservices.getClasses();
            map.put("classList",getclass);
            return new ModelAndView("addsection", map);
        }
        else{
        String classUniqueKey = addsectionform.classes.classUniqueKey;
        classModel classes=adminservices.getClassById(classUniqueKey);
        addsectionform.setClasses(classes);
        adminservices.addSection(addsectionform);
        classes.sections.add(adminservices.getSectionById(addsectionform.sectionUniqueKey));
        adminservices.addClass(classes);
         ModelAndView model=new ModelAndView("addsection");
            sectionModel section = new sectionModel();
            List<classModel> getclass = adminservices.getClasses();
            model.addObject("classList",getclass);
            model.addObject("sectionModel",section);
            model.addObject("message","New Section Has Been Added");
            return model;
        
        }
    }
    
        @RequestMapping(value = "emailpage" , method = RequestMethod.GET)
        public ModelAndView emailpage(HttpServletRequest request,HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("sendemail");
            List<classModel> getclass = adminservices.getClasses();
            model.addObject("classList",getclass);
            return model;
        }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }
 
        }
        
    @RequestMapping(value = "teachingstaffForm" , method = RequestMethod.GET)
    public ModelAndView teachingstaffForm(HttpSession httpSession, HttpServletRequest httpServletRequest){
        if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("addteachingstaff");
        List<classModel> getclasses = adminservices.getClasses();
        List<sectionModel> getSection=adminservices.getSection();
        List<subjectModel> getsubject = adminservices.getSubject();
        model.addObject("subjects",getsubject);
        model.addObject("classList",getclasses);
        model.addObject("sectionList",getSection);
        teachingstaffModel staff = new teachingstaffModel();
        model.addObject("teachingstaffModel",staff);
        return model;
    }
       else{
          return new ModelAndView("redirect:/restrictpage");
         } 
    }
    
    @RequestMapping(value = "teachingstaffadd" , method = RequestMethod.POST)
    public ModelAndView addteachingstaff(RedirectAttributes attributes,HttpServletRequest request, HttpSession httpSession,@Valid @ModelAttribute teachingstaffModel addTeacherForm, BindingResult bindingResult ){
      /*  if(bindingResult.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "from binding result");
            List<subjectModel> getsubject = adminservices.getSubject();
            map.put("subjects",getsubject);
            return new ModelAndView("addteachingstaff", map);
        }
        else{*/
      try{
        addTeacherForm.availability=1;
        adminservices.addTeachingStaff(addTeacherForm);
        teachingstaffModel teaching=adminservices.getTeachingStaffById(addTeacherForm.teachingstaffId);
        String[] checkBox = request.getParameterValues("subject");
	int[] integers = new int[checkBox.length];
        List<subjectModel> subjectsmodel=new ArrayList<subjectModel>();
        for (int i = 0; i < integers.length; i++){
            System.out.println("--------------------------");
            integers[i] = Integer.parseInt(checkBox[i]); 
            subjectModel subjects=adminservices.getSubjectById(integers[i]);
            subjectsmodel.add(subjects);
            }
            teaching.subject=subjectsmodel;
            adminservices.addTeachingStaff(teaching);
      }
      catch(NullPointerException e){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("error", "Please Select the subjects");
            map.put("message", "from catch");
            return new ModelAndView("addteachingstaff", map);
        }
         ModelAndView model=new ModelAndView("addteachingstaff");
        List<classModel> getclasses = adminservices.getClasses();
        List<sectionModel> getSection=adminservices.getSection();
        List<subjectModel> getsubject = adminservices.getSubject();
        model.addObject("subjects",getsubject);
        model.addObject("classList",getclasses);
        model.addObject("sectionList",getSection);
        teachingstaffModel staff = new teachingstaffModel();
        model.addObject("teachingstaffModel",staff);
        model.addObject("message","New Teacher Information Has Been Added");
        return model;
        
             
       
    }
    
   @RequestMapping(value="galleryform",method = RequestMethod.GET)
    public ModelAndView galleryForm(HttpSession httpSession,HttpServletRequest request){
        if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("addgallery");
        galleryModel gallery=new galleryModel();
        List<galleryModel> galleryname=adminservices.getGallery();
        model.addObject("galleryname",galleryname);
        model.addObject("gallerymodel",gallery);
        return model;
    }
         else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    
    @RequestMapping(value="galleryadd", method = RequestMethod.POST)
    public ModelAndView addGallery(HttpServletRequest request, HttpSession httpSession, @ModelAttribute galleryModel gallery, BindingResult bindingResult ){
        adminservices.addGalleryInfo(gallery);
        ModelAndView model=new ModelAndView("addgallery");
        galleryModel galleries=new galleryModel();
        List<galleryModel> galleryname=adminservices.getGallery();
        model.addObject("galleryname",galleryname);
        model.addObject("gallerymodel",galleries);
        model.addObject("message","New Gallery Has Been Added");
        return model;
    }
    
    @RequestMapping(value="addimageform",method = RequestMethod.GET)
    public ModelAndView addImageForm(HttpServletRequest request, HttpSession httpSession,@RequestParam(value="id") int galleryid){
        if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("addimage");
        imageModel imagemodel=new imageModel();
        galleryModel gallery=adminservices.getGalleryById(galleryid);
        imagemodel.setGallery(gallery);
        model.addObject("imagemodel",imagemodel);
        return model;
    }
         else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    
    @RequestMapping(value = "addimages",method = RequestMethod.POST)
    public ModelAndView addImagesController(HttpSession httpsession,@ModelAttribute imageModel image,HttpServletRequest request){
        galleryModel gallery=adminservices.getGalleryById(image.gallery.getGalleryId());
        List<imageModel> imagesmodel=new ArrayList<imageModel>();
        for(MultipartFile file:image.file){
        imageModel img=new imageModel();
         String code="PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
         String imagepath = FileUploadUtility.uploadFile(request,file,code);
         img.setImagePath(imagepath);
         img.setGallery(gallery);
         adminservices.addImages(img);
         imageModel imagees=adminservices.getImageById(image.getImageid());
         imagesmodel.add(imagees);
       }
        gallery.images=imagesmodel;
        adminservices.addGalleryInfo(gallery);
       return new ModelAndView("redirect:/galleryform");
    }
    
    @RequestMapping(value="viewgallaryallimages",method = RequestMethod.GET)
    public ModelAndView viewImageOfGalleryController(@RequestParam(value = "galleryid") int galleryid){
        
        ModelAndView model=new ModelAndView("viewImages");
        galleryModel imageslist=adminservices.getGalleryById(galleryid);
        model.addObject("images",imageslist);
        return model;
        
    }
    
    @RequestMapping(value="addevent",method = RequestMethod.GET)
    public ModelAndView addEventController(HttpSession httpSession){
        if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model = new ModelAndView("addevent");
        eventModel event=new eventModel();
        model.addObject("eventModel",event);
        return model;
    }
          else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }
    
    @RequestMapping(value="addEventdata",method = RequestMethod.POST)
    public ModelAndView addEventDataController(HttpSession httpsession,@ModelAttribute eventModel event){
        int smonth=Integer.parseInt(event.startmonth); 
        int emonth=Integer.parseInt(event.endmonth); 
        switch (smonth) {
            case 1:  event.startmonth = "January";
                     break;
            case 2:  event.startmonth = "February";
                     break;
            case 3:  event.startmonth = "March";
                     break;
            case 4:  event.startmonth = "April";
                     break;
            case 5:  event.startmonth = "May";
                     break;
            case 6:  event.startmonth = "June";
                     break;
            case 7:  event.startmonth = "July";
                     break;
            case 8:  event.startmonth = "August";
                     break;
            case 9:  event.startmonth = "September";
                     break;
            case 10: event.startmonth = "October";
                     break;
            case 11: event.startmonth = "November";
                     break;
            case 12: event.startmonth = "December";
                     break;
            default: event.startmonth = "Invalid month";
                     break;
        }
            switch (emonth) {
            case 1:  event.endmonth = "January";
                     break;
            case 2:  event.endmonth = "February";
                     break;
            case 3:  event.endmonth = "March";
                     break;
            case 4:  event.endmonth = "April";
                     break;
            case 5:  event.endmonth = "May";
                     break;
            case 6:  event.endmonth = "June";
                     break;
            case 7:  event.endmonth = "July";
                     break;
            case 8:  event.endmonth = "August";
                     break;
            case 9:  event.endmonth = "September";
                     break;
            case 10: event.endmonth = "October";
                     break;
            case 11: event.endmonth = "November";
                     break;
            case 12: event.endmonth = "December";
                     break;
            default: event.endmonth = "Invalid month";
                     break;
        }

        adminservices.addEvent(event);
       
        return new ModelAndView("redirect:/addevent");
    }
    
    @RequestMapping(value="setting", method=RequestMethod.GET)
    public ModelAndView settingEdit(HttpServletRequest httpServletRequest, HttpSession httpSession){
        if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("settings");
        adminModel admin=(adminModel)httpSession.getAttribute("adminlogged");
        
        model.addObject("adminModel",admin);
        return model;
    }
        else{
          return new ModelAndView("redirect:/restrictpage");
         }

    }

    @RequestMapping(value="manageUsername", method = RequestMethod.POST)
    public ModelAndView manageUsername(HttpServletRequest httpServletRequest, HttpSession httpSession,@Valid @ModelAttribute adminModel admin, BindingResult bindingResult){
    if(httpSession.getAttribute("adminlogged")!=null){
    adminservices.addAdmin(admin);
    return new ModelAndView("redirect:/setting");
    }
    else{
          return new ModelAndView("redirect:/restrictpage");
         }
    }
    
    @RequestMapping(value="changePassword",method = RequestMethod.POST)
    public ModelAndView changePasswordController(RedirectAttributes attributes,HttpSession httpSession,@RequestParam(value = "old") String oldpassword,@RequestParam(value = "new") String newpassword){
       if(httpSession.getAttribute("adminlogged")!=null){
        ModelAndView model=new ModelAndView("settings");
        adminModel admin=(adminModel)httpSession.getAttribute("adminlogged");
        if(oldpassword.equals(admin.password)){
            admin.setPassword(newpassword);
            adminservices.addAdmin(admin);
            model.addObject("pmessage", "Password has been changed");
        }
        else{
            model.addObject("pmessage", "Old Password Does not match");
        }
        
        adminModel admindata=(adminModel)httpSession.getAttribute("adminlogged");
        model.addObject("adminModel",admindata);
        return model;
    }
     else{
          return new ModelAndView("redirect:/restrictpage");
         }  
    }
    
     @RequestMapping(value = "addmarksheet",method = RequestMethod.GET)
        public ModelAndView marksheetForm(HttpServletRequest request,HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("addmarksheet");
            List<classModel> getclass = adminservices.getClasses();
            List<sectionModel> getsection = adminservices.getSection();
            model.addObject("classes",getclass);
            model.addObject("sections",getsection);
            return model;
        }
          else{
          return new ModelAndView("redirect:/restrictpage");
         }

        }

     @RequestMapping(value = "viewmarksheet",method = RequestMethod.POST)
        public ModelAndView marksheet(HttpServletRequest request,HttpSession httpSession, @RequestParam(value = "classid") String classid, @RequestParam(value="sectionsid") String sectionsid){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("addMarksheet2");
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classid,sectionsid);
            List<subjectModel> subjectlist = adminservices.getSubjectByClass(classid);
            model.addObject("students",studentlist);
            model.addObject("subjects",subjectlist);
            return model;
        }
            else{
          return new ModelAndView("redirect:/restrictpage");
         }
        }
        
        @RequestMapping(value = "addstudentmarksheet",method = RequestMethod.POST)
        public ModelAndView addmark(HttpSession httpSsession,@ModelAttribute markSheet mark){
           int sum=0;
            String[] reg = mark.studentRegistrationNumber.split("\\,");
           String[] sub = mark.subjectName.split("\\,");
           String[] markobt = mark.marksObtained.split("\\,");
           String[] markobtpratical = mark.marksObtainedPratical.split("\\,");
         String[] theoryfullmark = mark.theoryFullMark.split("\\,");
         String[] theorypassmark = mark.theoryPassMark.split("\\,");
         String[] practicalfullmark = mark.practicalFullMark.split("\\,");
         String[] practicalpassmark = mark.practicalPassMark.split("\\,");
         
          for(String element:sub){ 
              sum ++;
          }
          
          for(int i=0;i<sum;i++){
              System.out.println("--------"+reg[i]+"----"+sub[i]+"----"+markobt[i]);
              markSheet stdmarks=new markSheet();
              int studentid=Integer.parseInt(reg[i]);
              studentModel student=adminservices.getStudentById(studentid);
              stdmarks.student=student;
              stdmarks.subjectName=sub[i];
              stdmarks.marksObtained=markobt[i];
              stdmarks.marksObtainedPratical=markobtpratical[i];
              stdmarks.theoryFullMark=theoryfullmark[i];
              stdmarks.theoryPassMark=theorypassmark[i];
              stdmarks.practicalFullMark=practicalfullmark[i];
              stdmarks.practicalPassMark=practicalpassmark[i];
              if("abs".equals(markobt[i])){
                  stdmarks.total=Integer.parseInt(markobtpratical[i]);
              }
              else if("abs".equals(markobtpratical[i])){
                  stdmarks.total=Integer.parseInt(markobt[i]);
              }
               else if("abs".equals(markobtpratical[i]) && "abs".equals(markobt[i]) ){
                  stdmarks.total=0;
              }
              else{
              stdmarks.total= Integer.parseInt(markobt[i])+Integer.parseInt(markobtpratical[i]);
              }
              adminservices.addStudentMarksheet(stdmarks);
          }
           ModelAndView model=new ModelAndView("addMarksheet2");
           String[] std = mark.studentRegistrationNumber.split("\\,");
           int stdid=Integer.parseInt(std[0]);
           studentModel student=adminservices.getStudentById(stdid);
           String classid=student.classes.classUniqueKey;
           String sectionid=String.valueOf(student.section.sectionUniqueKey);
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classid,sectionid);           
            model.addObject("students",studentlist);
            model.addObject("message","Student marks has been added");
            return model;
        }
        
        
        
        @RequestMapping(value = "marksheetupload", method = RequestMethod.GET)
            public ModelAndView marksheetupload(@RequestParam(value="studentId") int studentId, @RequestParam(value="classId") String classId,@RequestParam(value="sectionId") String sectionId){
                ModelAndView model = new ModelAndView("marksheetupload");
                markSheet mark=new markSheet();
                List<subjectModel> subjectlist = adminservices.getSubjectByClass(classId);
                List<studentModel> studentlist=adminservices.getStudentByClassSection(classId,sectionId);
                studentModel studentinfo=adminservices.getStudentById(studentId);
                model.addObject("students",studentlist);
                model.addObject("studentinfo", studentinfo);
                model.addObject("markSheet", mark);
                model.addObject("subjects",subjectlist);
                return model;
            }
            
            @RequestMapping(value = "print",method=RequestMethod.GET)
            public ModelAndView printMarksheet(HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("printmarksheet");
            List<classModel> getclass = adminservices.getClasses();
            List<sectionModel> getsection = adminservices.getSection();
            model.addObject("classes",getclass);
            model.addObject("sections",getsection);
            return model;
            }
            else{
          return new ModelAndView("redirect:/restrictpage");
         }

            }
            

    @RequestMapping(value = "deletestudentmarksheet",method=RequestMethod.GET)
            public ModelAndView deleteMarksheet(HttpSession httpSession,@RequestParam(value = "id") int studentid, @RequestParam(value = "classId") String classid,@RequestParam(value = "sectionId") String sectionsid ){
            if(httpSession.getAttribute("adminlogged")!=null){
            adminservices.deleteMarksheet(studentid);
            ModelAndView model=new ModelAndView("viewmarksheet2");
            List<studentModel> studentlist=adminservices.getStudentByClassSection(classid, sectionsid);
            model.addObject("student",studentlist);
            return model;
            }
                     else{
          return new ModelAndView("redirect:/restrictpage");
         }

            }
            @RequestMapping(value = "deleteallmarksheet",method=RequestMethod.GET)
            public ModelAndView deleteAllMarksheet(){
                adminservices.deleteAllMarkSheet();
                return new ModelAndView("admindashboard");
            }
            
    
    @RequestMapping(value = "billing",method=RequestMethod.GET)
            public ModelAndView billing(HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){    
            ModelAndView model=new ModelAndView("billing");
            List<classModel> getclass = adminservices.getClasses();
            List<sectionModel> getsection = adminservices.getSection();
            model.addObject("classes",getclass);
            model.addObject("sections",getsection);
            return model;
            }
            else{
          return new ModelAndView("redirect:/restrictpage");
            }
            }
      @RequestMapping(value = "sectiondelete",method=RequestMethod.GET)
            public ModelAndView sectionDelete(HttpSession httpSession,@RequestParam(value = "id") int sectionid,@RequestParam(value = "classId") String classid){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("viewsection");
            List<classModel> getclass = adminservices.getClasses();
            String delsection=adminservices.deletesection(sectionid);

             List<sectionModel> section=adminservices.getSectionByClassUniqueKey(classid);
                model.addObject("sectionlists",section);
                model.addObject("classes",getclass);
                if("fail".equals(delsection)){
                model.addObject("message","Student Exist in Section first delete student in section");
            }
                return model;
            }
                     else{
          return new ModelAndView("redirect:/restrictpage");
         }

            
            }
            @RequestMapping(value = "editmarksheetofstudent",method=RequestMethod.POST)
            public ModelAndView editMarksheet(HttpSession httpSession,@RequestParam(value = "marksheetId") int marksheetid,@RequestParam(value = "markobtained") String theory,@RequestParam(value = "markobtainedpratical") String pratical){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("viewmarksheet3");
            markSheet marks=adminservices.getMarkSheetById(marksheetid);
            marks.setMarksObtained(theory);
            marks.setMarksObtainedPratical(pratical);
            adminservices.addStudentMarksheet(marks);
            String sectionid=Integer.toString(marks.student.section.sectionUniqueKey);
            List<studentModel> studentlist=adminservices.getStudentByClassSection(marks.student.classes.classUniqueKey,sectionid);          
            List<markSheet> stdmark=adminservices.getMarkByStudentId(marks.student.studentId);
            studentModel studentinfo=adminservices.getStudentById(marks.student.studentId);
            model.addObject("studentinfo", studentinfo);
            model.addObject("students",studentlist);
            model.addObject("markSheet",stdmark);
            model.addObject("editmessage","Change to the marksheet has been made");
            return model;            
            }
            else{
          return new ModelAndView("redirect:/restrictpage");
         }

            }
            
            @RequestMapping(value = "classdelete",method=RequestMethod.GET)
            public ModelAndView deleteClass(@RequestParam(value = "id") String classuniquekey,HttpSession httpSession) {     
               if(httpSession.getAttribute("adminlogged")!=null){
                String delete= adminservices.DeleteClasses(classuniquekey);
              
                List<classModel> classdetails = adminservices.getClasses();
                HashMap<String, Object> map = new HashMap<String, Object>();
                if("fail".equals(delete)){
                map.put("message", "Student Exist in the class so could not delete class");
                }
                else{
                    map.put("message", "Class Has Been Deleted");
                }
                map.put("classes", classdetails);
                
                return new ModelAndView("viewclass",map);
    }
                 else{
          return new ModelAndView("redirect:/restrictpage");
         }
               
            }
            @RequestMapping(value = "admitcard",method=RequestMethod.GET)
            public ModelAndView admitcard(HttpSession httpSession){
            if(httpSession.getAttribute("adminlogged")!=null){
            ModelAndView model=new ModelAndView("admitcard1");
            List<classModel> getclass = adminservices.getClasses();
            List<sectionModel> getsection = adminservices.getSection();
            model.addObject("classes",getclass);
            model.addObject("sections",getsection);
            return model;
    }
              else{
          return new ModelAndView("redirect:/restrictpage");
         }
            
            }
    @RequestMapping(value="restrictpage",method = RequestMethod.GET)
    public ModelAndView restrictPage(){
              
            ModelAndView model=new ModelAndView("home");
            adminModel admin = new adminModel();
            staffModel staff = new staffModel();
            studentModel parents = new studentModel();
            model.addObject("adminModel",admin);
            model.addObject("staffModel",staff);
            model.addObject("studentModel",parents);
            model.addObject("message","First you need to login to the system");
            return model;
      
    }

}
