package com.capricon.web.controller;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



public class EmailUtility {
	
	public static void sendEmail(String to, String subject, String body) {
		String from = "dogovicky05@gmail.com";
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
	    //properties.put("mail.smtp.starttls.enable", "true");
	    properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
	    
	    
	    Session session = Session.getInstance(properties, new Authenticator() {
	    	
	    	protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dogovicky05@gmail.com", "Capricon005$");
            }
	    	
		}); 
	    
	    try {
	    	MimeMessage message = new MimeMessage(session);
	    	message.setFrom(new InternetAddress(from));
	    	message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);
            
            Transport.send(message);
            System.out.println("Message sent successfully");
            
	    } catch (MessagingException mex) {
            mex.printStackTrace();
        }
	    
	    
	}

}















