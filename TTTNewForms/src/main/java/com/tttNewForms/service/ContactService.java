package com.tttNewForms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tttNewForms.dto.CareerForm;
import com.tttNewForms.dto.ContactForm;

@Service
public class ContactService {

	@Autowired
	private JavaMailSender emailSender;

	public void sendGetInTouchEmail(ContactForm form) {
		SimpleMailMessage message = new SimpleMailMessage();

		
		message.setTo("contactus@talenttrektechnologies.com"); 
		message.setSubject("New Contact Us Form Submission");
		message.setText("Name: " + form.getName() + "\n" + "Contact: " + form.getPhone() + "\n" + "Email: "
				+ form.getEmail() + "\n" + "Message: " + form.getMessage());

		emailSender.send(message);
	}

	public void sendCareerApplicationEmail(CareerForm form) {
		SimpleMailMessage message = new SimpleMailMessage();

		
		message.setTo("contactus@talenttrektechnologies.com"); 		
		message.setSubject("New Career Application Submission");
		message.setText("Name: " + form.getName() + "\n" + "Phone: " + form.getPhone() + "\n" + "Email: "
				+ form.getEmail() + "\n" + "Qualification: " + form.getQualification() + "\n" + "Experience: "
				+ form.getExperience() + "\n" + "Skills: " + form.getSkills());

		emailSender.send(message);
	}
}
