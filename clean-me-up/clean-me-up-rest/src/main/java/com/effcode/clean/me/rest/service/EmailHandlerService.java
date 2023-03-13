package com.effcode.clean.me.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effcode.clean.me.support.SmtpEmail;
import com.effcode.clean.me.support.SmtpHandler;

//Class for Email Handler Service Interface

Logger log = LoggerFactory.getLogger(EmailHandlerService.class);

@Service
public interface EmailHandlerService {

    /**
    Method to send mail and call the service implementation class
    **/
    try {
    String sendMail(EmailDetails details);
    } 
    catch (Exception e) {
    log.error ("Sending mail failed. Exception thrown : " +e)
  }
}
