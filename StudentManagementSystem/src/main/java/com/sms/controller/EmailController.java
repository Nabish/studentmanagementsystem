package com.sms.controller;

import com.sms.model.studentModel;
import com.sms.model.subjectModel;
import com.sms.services.adminServices;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

	static String emailToRecipient, emailSubject, emailMessage;
	static final String emailFromRecipient = "maharjan.rohit1996@gmail.com";
        
        @Autowired
        adminServices adminservices;
        
	@Autowired
	private JavaMailSender mailSenderObj;


	// This Method Is Used To Prepare The Email Message And Send It To The Client
	@RequestMapping(value = "sendEmail", method = RequestMethod.POST)
	public ModelAndView sendEmailToClient(HttpServletRequest request, final @RequestParam CommonsMultipartFile attachFileObj) {		
            List<String> emailToRecipient=null;	
            String reciver=request.getParameter("receiver");
                emailSubject = request.getParameter("subject");
		emailMessage = request.getParameter("message");
                if(reciver.equals("all")){
                   emailToRecipient=adminservices.getStudent();
                    
                }
                if(reciver.equals("class")){
                    String[] checkBox = request.getParameterValues("classuniquekey");
                    int[] integers = new int[checkBox.length];
                    for (int i = 0; i < integers.length; i++){
                        integers[i] = Integer.parseInt(checkBox[i]); 
                        emailToRecipient=adminservices.getStudentEmailByClass(integers[i]);
                        System.out.println("--------------------------"+integers[i]);
                        
            }
                    
                }
		
                for(final String email:emailToRecipient){
		mailSenderObj.send(new MimeMessagePreparator() {
                        @Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");				
				mimeMsgHelperObj.setTo(email);
				mimeMsgHelperObj.setFrom(emailFromRecipient);				
				mimeMsgHelperObj.setText(emailMessage);
				mimeMsgHelperObj.setSubject(emailSubject);

				// Determine If There Is An File Upload. If Yes, Attach It To The Client Email				
				if ((attachFileObj != null) && (attachFileObj.getSize() > 0) && (!attachFileObj.equals(""))) {
					System.out.println("\nAttachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
					mimeMsgHelperObj.addAttachment(attachFileObj.getOriginalFilename(), new InputStreamSource() {					
						public InputStream getInputStream() throws IOException {
							return attachFileObj.getInputStream();
						}
					});
				} else {
					System.out.println("\nNo Attachment Is Selected By The User. Sending Text Email!\n");
				}
			}
		});
                }
                ModelAndView model = new ModelAndView("sendemail");
		model.addObject("message","Email has been send");
                return model;
	}
       
}