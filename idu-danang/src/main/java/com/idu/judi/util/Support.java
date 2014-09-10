package com.idu.judi.util;

import java.sql.Date;
import java.util.Random;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;

public class Support {
	public static Date getCurrentDate() {
		return new Date((new java.util.Date()).getTime());
	}

	public static String randomCode(int size) {
		String str01 = "abcdefghijklmnopqrstuvwxyz";
		String str02 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String str03 = "0123456789";
		String strValid = str01 + str02 + str03;
		Random random = new Random();
		String result = "";
		for (int i = 0; i < size; i++) {
			int randnum = random.nextInt(strValid.length());
			result += strValid.charAt(randnum);
		}
		return result;
	}
	 public static boolean sendMailContact(String fullName, String toEmail, String phone, String title, String content) {
	        boolean check;
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class",
	                "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");

	        Session session = Session.getDefaultInstance(props,
	                new javax.mail.Authenticator() {
	                    @Override
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(com.idu.judi.util.Constants.FROM_EMAIL, com.idu.judi.util.Constants.PASSWORD_EMAIL);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(com.idu.judi.util.Constants.FROM_EMAIL));
	            message.setRecipients(Message.RecipientType.TO,
	                    InternetAddress.parse(Constants.TO_EMAIL));
	            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
	            message.setHeader("Content-Encoding", "ISO-8859-9");
	            message.setSubject("Feedback from users. " + toEmail);
	            String body = "Title " + title + "\n"
	                    + "Email: " + toEmail + "\n"
	                    + "Full Name: " + fullName + "\n"
	                    + "Phone: " + phone + "\n"
	                    + "Content: \n" + content;
	            message.setText(body);
	            message.setContent(body, "text/plain; charset=UTF-8");
	            Transport.send(message);
	            check = true;

	        } catch (MessagingException e) {
	            check = false;
	            throw new RuntimeException(e);
	        }
	        return check;
	    }
}
