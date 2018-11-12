/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;
import com.sms.model.classModel;
import com.sms.model.eventModel;
import com.sms.model.sectionModel;
import com.sms.services.adminServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author nabish
 */
@RestController
public class RestControllers {
    @Autowired
    adminServices adminservices;
    
    @RequestMapping(value="calender",method = RequestMethod.GET)
        public List<eventModel> getEventController(@RequestParam("month") String month){
            List<eventModel> events=adminservices.getEventByMonth(month); 
            return events;
    }
    
        @RequestMapping(value="getclasssection",method = RequestMethod.GET)
        public List<sectionModel> getClassesSection(@RequestParam("classuniquekey") String classuniquekey){
            List<sectionModel> section=adminservices.getSectionByClassId(classuniquekey);
            return section;
    }
}
