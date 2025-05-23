package com.tttNewForms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tttNewForms.dto.CareerForm;
import com.tttNewForms.dto.ContactForm;
import com.tttNewForms.service.ContactService;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:3000")
public class FormsController {

    @Autowired
    private ContactService contactService;

   
    @PostMapping("/getintouch")
    public String getInTouch(@RequestBody ContactForm form) {
        contactService.sendGetInTouchEmail(form); 
        return "Thank You for Contacting Us!";
    }

    
    @PostMapping("/career")
    public String applyForCareer(@RequestBody CareerForm form) {
        contactService.sendCareerApplicationEmail(form); 
        return "Your application has been submitted successfully!";
    }
}
