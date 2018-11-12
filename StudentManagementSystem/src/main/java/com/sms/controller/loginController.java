/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.model.adminModel;
import com.sms.model.staffModel;
import com.sms.model.studentModel;
import com.sms.model.superAdminModel;
import com.sms.services.ParentsServices;
import com.sms.services.adminServices;
import com.sms.services.staffServices;
import com.sms.services.superAdminServices;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author nabish
 */
@Controller
public class loginController {
    
    @Autowired
    adminServices adminservices;
    
     @Autowired
     staffServices staffService;
     
    @Autowired
    ParentsServices parentsservices;
    
    @Autowired
    superAdminServices superadminservices;
    
    @Autowired
    SessionFactory sessionFactory;
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @RequestMapping (value="adminlogin", method = RequestMethod.POST)
    public ModelAndView adminLogin(HttpSession httpSession , HttpServletRequest request , @ModelAttribute adminModel admin){
        adminModel adminExist=adminservices.adminLogin(admin);
       String check=adminExist.username;
       
       
       if(!"notfound".equals(check)){
           Date edate=adminExist.expirydate;
           Date cdate=new Date();
           if(edate.before(cdate)){
           adminservices.setActivation(adminExist.adminid);
           ModelAndView model= new ModelAndView("activation");
           model.addObject("admin",adminExist);
           return model;  
           }
           
           if(adminExist.activated==0){
           ModelAndView model= new ModelAndView("activation");
           model.addObject("admin",adminExist);
           return model;
           } 
           
           System.out.println("------------"+adminExist.expirydate);
           
            request.getSession().setAttribute("adminlogged", adminExist);
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
            ModelAndView modelfailed=new ModelAndView("home");
            adminModel adminmodel = new adminModel();
            staffModel staff = new staffModel();
            studentModel parents = new studentModel();
            modelfailed.addObject("adminModel",adminmodel);
            modelfailed.addObject("staffModel",staff);
            modelfailed.addObject("studentModel",parents);
            modelfailed.addObject("message","UserName or Password is Incorrect!");
            return modelfailed;
        }
       
    }
    
    @RequestMapping(value = "loginstaff" , method = RequestMethod.POST)
        public ModelAndView loginStaff(HttpServletRequest request,HttpSession httpSession, @ModelAttribute staffModel staffmodel , BindingResult bindingResult , RedirectAttributes redirectAttributes){
                staffModel userExists = staffService.checkLogin(staffmodel);
                
                String check = userExists.username;
		//if(userExists == null){
               if(check != "notfound"){
                   return new ModelAndView("staffdashboard");
               }else{
                   return new ModelAndView("redirect:/");
               }
           }
        
         @RequestMapping(value = "parentslogin" , method = RequestMethod.POST)
        public ModelAndView loginUser(HttpServletRequest request,HttpSession httpSession, @ModelAttribute studentModel studentmodel , BindingResult bindingResult , RedirectAttributes redirectAttributes){
               String decodedpassword = DatatypeConverter.printBase64Binary(studentmodel.password.getBytes());
               //String decodedpassword = new String(DatatypeConverter.parseBase64Binary(studentmodel.password));
               System.out.println("decodedpassword"); 
               studentmodel.password=decodedpassword;
                studentModel userExists = parentsservices.checkLogin(studentmodel);
                
                String check = userExists.username;
               if(check != "notfound"){
                   request.getSession().setAttribute("studentinfo", userExists);
                   return new ModelAndView("parentsdashboard");
               }else{
                 ModelAndView model=new ModelAndView("home");
                adminModel adminmodel = new adminModel();
                staffModel staff = new staffModel();
                studentModel parents = new studentModel();
                model.addObject("adminModel",adminmodel);
                model.addObject("staffModel",staff);
                model.addObject("studentModel",parents);
                model.addObject("message","UserName or Password is Incorrect!");
                return model;
               }
           }
        @RequestMapping( value = "logout" , method = RequestMethod.GET)
        public ModelAndView logout(HttpServletRequest request, HttpSession httpSession){
              httpSession.getAttribute("adminlogged");
              System.out.println(httpSession.getAttribute("adminlogged"));
              httpSession.invalidate();
            return new ModelAndView("redirect:/");
        }
        
        @RequestMapping( value = "parentslogout" , method = RequestMethod.GET)
        public ModelAndView parentLogout(HttpServletRequest request, HttpSession httpSession){
              httpSession.getAttribute("studentinfo");
              httpSession.invalidate();
              return new ModelAndView("redirect:/");
        }
        @RequestMapping( value = "superadminlogout" , method = RequestMethod.GET)
        public ModelAndView superAdminLogout(HttpServletRequest request, HttpSession httpSession){
              httpSession.getAttribute("superadmin");
              httpSession.invalidate();
              return new ModelAndView("redirect:/");
        }

        
         @RequestMapping(value = "superadminlogin" , method = RequestMethod.POST)
        public ModelAndView superAdminloginUser(HttpServletRequest request,HttpSession httpSession,@RequestParam(value="username") String uname,@RequestParam(value = "password") String pass){
               
               if("codehousemediasolutions".equals(uname) && "v1@c)$=#>j9x[3".equals(pass)){
                   request.getSession().setAttribute("superadmin","superadminlogin");
                   ModelAndView model=new ModelAndView("superadmin/dashboard");
                   List<adminModel> adminlist=superadminservices.getAdminList();
                   model.addObject("adminlist",adminlist);
                   return model; 
               }else{
                 ModelAndView modelfailed=new ModelAndView("superadmin/login");
                 superAdminModel sadmin=new superAdminModel();
                 modelfailed.addObject("superAdminModel",sadmin);
                 modelfailed.addObject("message","Username Or Password Is Incorrect!");
                 return modelfailed;
               }
           }
        
}
