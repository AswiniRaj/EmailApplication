package com.effcode.clean.me.rest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effcode.clean.me.support.SmtpEmail;
import com.effcode.clean.me.support.SmtpHandler;
import com.effcode.clean.me.rest.service;

//Implementing Email Service Handler Interface class
@Service
public class EmailHandlerServiceImpl implements EmailHandlerService {
    
    @Autowired
    public SmtpHandler smtpHandler;

    @Autowired
    private EmailDetails emailDetails;

    @Value("${spring.mail.username}")
    private String emailUserName;

    @Value("${spring.mail.password}")
    private String emailPassword;
    
    Logger log = LoggerFactory.getLogger(EmailHandlerServiceImpl.class);
    
    /**
    Method to get the email details and null check the subject and length of the content and sent it back
    to SMTP server, post the request and send the email
    **/

    public boolean send(EmailDetails emailDetails) throws exception {
        log.info("Address: " + emailDetails.getAddress());
        log.info("Subject: " + emailDetails.getSubject());
        log.info("Content: " + emailDetails.getContent());
	
	//Check whether the subject is null or not
        try {
        if(emailDetails.getSubject().isEmpty) {
            log.error("Subject is null");
            return false;
        }
	
	//Check if the length of the email content is withing the given limit
        if(emailDetails.getContent().length() > 65000) {
            log.error("The length of the content is big" + content.length());
            return false;
        }

	//Post the request to the SMTP email Server and send to the Address with the provided Subject and content
        SmtpEmail smtpEmail = new SmtpEmail();
        smtpEmail.adrs = new String[] {emailDetails.getAddress()};
        smtpEmail.content = emailDetails.getContent();
        smtpEmail.subject = emailDetails.getSubject();
        smtpEmail.password =  emailPassword;
        smtpEmail.username =  emailUserName;
        smtpHandler.post(smtpEmail);
        log.info("Send email to the Address: " + emailDetails.getAddress() + ", Subject: " + emailDetails.getSubject());
        return true;
    } 
  } catch (Exception e) {
 	log.error ("Send Method --> Sending mail failed. Exception thrown : " +e)
  }
}
