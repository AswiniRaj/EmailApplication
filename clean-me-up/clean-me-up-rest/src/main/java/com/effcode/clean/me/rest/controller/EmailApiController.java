package com.effcode.clean.me.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.effcode.clean.me.rest.service.EmailHandlerService;
import com.effcode.clean.me.rest.model.EmailDetails;

@RestController
public class EmailApiController {

    @Autowired
    private EmailHandlerService emailHandlerService;

    @Autowired
    private EmailDetails emailDetails;
    
    Logger log = LoggerFactory.getLogger(EmailApiController.class);

    /**Service call to send a simple email)
    @PostMapping("/sendEmailApi")
    public ResponseEntity<> send(@RequestBody EmailDetails emailDetails) throws exception {

	//Call the Email Handler Service class
        boolean state = emailHandlerService.send(emailDetails);
        if (state) {
            return new ResponseEntity<>(HttpStatus.OK);
	    log.info("Email sent successfully");
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            log.error("Delivery Failed - Unable to send email to the user");
        }
    }
}
