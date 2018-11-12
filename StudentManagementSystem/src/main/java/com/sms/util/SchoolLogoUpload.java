/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sms.util;
import java.io.File;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;


public class SchoolLogoUpload {
    private static final String ABS_PATH = "C:\\SchoolLogo\\";
    private static String REAL_PATH = "";
    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
    public static String uploadFile(HttpServletRequest request, MultipartFile file, String code) {
        
    //get real path    
        REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/image/");
        logger.info(REAL_PATH);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(!new File(ABS_PATH).exists()){
            new File(ABS_PATH).mkdirs();
        }
                if(!new File(REAL_PATH).exists()){
            new File(REAL_PATH).mkdirs();
        }
              try{
                  file.transferTo(new File(REAL_PATH+ code + ".jpg"));
                  file.transferTo(new File(ABS_PATH+ code + ".jpg"));
              }  
               catch(IOException e){
                   
               } 
              return (code+".jpg");
    }
    
}
