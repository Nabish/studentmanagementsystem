/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.model.feedbackModel;
import com.sms.model.markSheet;
import com.sms.model.studentModel;
import com.sms.services.ParentsServices;
import com.sms.services.adminServices;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anis
 */
@Controller
public class parentController {
     @Autowired
    ParentsServices parentservices;
     
     @Autowired
     adminServices adminservices;
     
    
    @RequestMapping("addFeedback")
    public ModelAndView feedbackForm(){
        feedbackModel feedback = new feedbackModel();
        ModelAndView model = new ModelAndView("addfeedback");
        model.addObject("feedbackModel",feedback);
        return model;
    }
    
    @RequestMapping(value = "addfeedback" , method = RequestMethod.POST)
    public ModelAndView addFee(HttpServletRequest request, HttpSession httpSession,@Valid @ModelAttribute feedbackModel addfeedback, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> map = new HashMap<String, Object>();
            map.put("message", "Fill all the informations correctly");
            return new ModelAndView("feedback", map);
        }
        else{
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            addfeedback.setReceivedDate(timestamp);
            addfeedback.setViewed(1);
            studentModel std=(studentModel)httpSession.getAttribute("studentinfo");
            addfeedback.setStudent(std);
            parentservices.addFeedback(addfeedback);
            ModelAndView model=new ModelAndView("addfeedback");
            feedbackModel feedback = new feedbackModel();
            model.addObject("message","Feedback has been send");
            model.addObject("feedbackModel",feedback);
            return model;
        }
    }
    
    @RequestMapping("parentMarksheet")
    public ModelAndView studentMarksheet(HttpSession httpSession){
        ModelAndView model=new ModelAndView("parentmarksheet");
        studentModel std=(studentModel)httpSession.getAttribute("studentinfo");
        List<markSheet> stdmarksheet=parentservices.getStudentMarksheetById(std.studentId);
        int totalmark=0;
        int totalsub=0;
        
        String result="";
        for(markSheet mark:stdmarksheet){
            totalmark=totalmark+mark.total;
            totalsub++;
        }
        for(markSheet res:stdmarksheet){
            if(res.total<40){
                result="fail";
                break;
            }
            if(res.total>40){
            result="pass";
            }
        }
        String division;
        int percentage=totalmark/totalsub;
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
        model.addObject("percentage",percentage);
        model.addObject("result",result);
        model.addObject("division",division);
        model.addObject("total",totalmark);
        model.addObject("marks",stdmarksheet);
        model.addObject("studentinfo",std);
        return model;
    }
}
