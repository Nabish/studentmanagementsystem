/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.controller;

import com.sms.model.adminModel;
import com.sms.model.productKeyModel;
import com.sms.model.superAdminModel;
import com.sms.services.superAdminServices;
import com.sms.util.FileUploadUtility;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author nabish
 */
@Controller
public class superAdminController {
    
    @Autowired
    superAdminServices superadminservices;
    
     @RequestMapping("addadmin")
    public ModelAndView addAdminForm(HttpSession httpsession){
        if(httpsession.getAttribute("superadmin")!=null){
         adminModel admin = new adminModel();
        ModelAndView model = new ModelAndView("superadmin/addadmin");
        model.addObject("adminModel",admin);
        return model;
        }
        else{
            ModelAndView modelfailed=new ModelAndView("superadmin/login");
            superAdminModel sadmin=new superAdminModel();
            modelfailed.addObject("superAdminModel",sadmin);
            return modelfailed; 
        }
    }
    
    @RequestMapping(value = "addschoolinformation",method = RequestMethod.POST)
    public ModelAndView addSchool(HttpSession session,@ModelAttribute adminModel admin,HttpServletRequest request,@RequestParam (value="date") String edate)throws ServletException,IOException{
       ModelAndView model=new ModelAndView("superadmin/addadmin");
       String imagepath=null;
       if("".equals(edate)){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        admin.setExpirydate(cal.getTime());
       }
       else{
           adminModel admininfo=superadminservices.getAdminById(admin.adminid);
           admin.setExpirydate(admininfo.expirydate);
       }
       superadminservices.addschool(admin);
       if(!admin.getLogo().getOriginalFilename().equals("")){
          String code=admin.getCode();
          imagepath = FileUploadUtility.uploadFile(request,admin.getLogo(),code);
          admin.setSchoolLogo(imagepath);
        }
     superadminservices.addschool(admin);
     adminModel admins = new adminModel();
     model.addObject("adminModel",admins);
       model.addObject("message","added");
        return model;
    }
    
    @RequestMapping(value="adminactivation",method = RequestMethod.POST)
    public ModelAndView adminActivation(@RequestParam(value="adminid") int adminid,@RequestParam(value="productkey") String productkey){
        System.out.println("-----------------"+adminid+"-------------"+productkey);
        String result=superadminservices.adminActivation(adminid,productkey);
        System.out.println("----------your account has been activated using"+result+"product key");
        return new ModelAndView("redirect:/");
    }
        @RequestMapping(value="addproductkey",method = RequestMethod.GET)
    public ModelAndView addProductKey(HttpSession httpsession){
        if(httpsession.getAttribute("superadmin")!=null){
        ModelAndView model=new ModelAndView("superadmin/addproductkey");
        List<productKeyModel> productkeylist=superadminservices.getProductKeyList();
        productKeyModel productkey=new productKeyModel();
        model.addObject("productKeyModel",productkey);
        model.addObject("productkeylist",productkeylist);
        return model;
    }
        else{
            ModelAndView modelfailed=new ModelAndView("superadmin/login");
            superAdminModel sadmin=new superAdminModel();
            modelfailed.addObject("superAdminModel",sadmin);
            return modelfailed;   
        }
    }
    @RequestMapping(value="addproductinformation",method = RequestMethod.POST)
    public ModelAndView addProductKeyInformation(@ModelAttribute productKeyModel productkey){
        productkey.availability=1;
        superadminservices.addProductKey(productkey);
        ModelAndView model=new ModelAndView("superadmin/addproductkey");
        productKeyModel productkeys=new productKeyModel();
        List<productKeyModel> productkeylist=superadminservices.getProductKeyList();
        model.addObject("productkeylist",productkeylist);
        model.addObject("message","new Product Key Has been added");
        model.addObject("productKeyModel",productkeys);
        return model;
    }
    
   @RequestMapping(value="editadmininfo",method = RequestMethod.GET)
    public ModelAndView editAdminInfo(@RequestParam (value="adminid") int adminid,HttpSession httpsession){
        if(httpsession.getAttribute("superadmin")!=null){
        ModelAndView model=new ModelAndView("superadmin/addadmin");
        adminModel admin=superadminservices.getAdminById(adminid);
        model.addObject("adminModel",admin);
        return model;
    }
        else{
             ModelAndView modelfailed=new ModelAndView("superadmin/login");
            superAdminModel sadmin=new superAdminModel();
            modelfailed.addObject("superAdminModel",sadmin);
            return modelfailed;  
        }
   }
   @RequestMapping(value="superadmindashboard",method = RequestMethod.GET)
    public ModelAndView superAdminDashboars(HttpSession httpsession){
        if(httpsession.getAttribute("superadmin")!=null){
        ModelAndView model=new ModelAndView("superadmin/dashboard");
                   List<adminModel> adminlist=superadminservices.getAdminList();
                   model.addObject("adminlist",adminlist);
                   return model; 
        }
        else{
             ModelAndView modelfailed=new ModelAndView("superadmin/login");
            superAdminModel sadmin=new superAdminModel();
            modelfailed.addObject("superAdminModel",sadmin);
            return modelfailed;  
        }
   
    
}
}
