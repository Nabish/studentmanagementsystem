/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.model.adminModel;
import com.sms.model.eventModel;
import com.sms.model.staffModel;
import com.sms.model.studentModel;
import com.sms.model.superAdminModel;
import com.sms.services.adminServices;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author nabish
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public ModelAndView HomeController(HttpSession httpSession){
        return new ModelAndView("home/FrontPage");
    }
    
    @RequestMapping("startpage")
    public ModelAndView StartController(HttpSession httpSession){
        return new ModelAndView("home/FrontPage");
    }
    @RequestMapping("features")
    public ModelAndView featuresController(HttpSession httpSession){
        return new ModelAndView("home/Features");
    }
    @RequestMapping("about")
    public ModelAndView aboutController(HttpSession httpSession){
        return new ModelAndView("home/About");
    }
    @RequestMapping(value="loginpage",method = RequestMethod.GET)
    public ModelAndView loginPage(){
    ModelAndView model=new ModelAndView("home");
    adminModel admin = new adminModel();
    staffModel staff = new staffModel();
    studentModel parents = new studentModel();
    model.addObject("adminModel",admin);
    model.addObject("staffModel",staff);
    model.addObject("studentModel",parents);
    return model;
        
}
    @RequestMapping(value = "viewevent",method = RequestMethod.GET)
    public ModelAndView viewcalender(){
        return new ModelAndView("eventview");
    }

    @RequestMapping("/superadminloginpage")
    public ModelAndView superAdminLoginpage(HttpSession httpSession){
    ModelAndView model=new ModelAndView("superadmin/login");
    superAdminModel sadmin=new superAdminModel();
    model.addObject("superAdminModel",sadmin);
    return model;
}
}
