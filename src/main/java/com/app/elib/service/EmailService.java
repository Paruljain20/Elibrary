package com.app.elib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailSender;


@Service("emailservice")
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String to, String from, String sub, String body){
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(sub);
		mailMessage.setText(body);
		mailSender.send(mailMessage);
	}

}
