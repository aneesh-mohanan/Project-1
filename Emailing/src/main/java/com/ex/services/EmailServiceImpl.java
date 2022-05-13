package com.ex.services;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class EmailServiceImpl implements EmailService{
    /**
     *
     * @param emailId The email id of receiver
     * @param message The message to be sent on email
     * @throws AddressException
     * @throws MessagingException
     */
    @Override
    public void sendmail(String emailId, String message) throws AddressException, MessagingException {
        if(emailId == null || message == null){
            throw new IllegalStateException("Email id and message can't be null");
        }

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("AneeshRevatureProject1@gmail.com", "RevatureBank2022");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("AneeshRevatureProject1@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
        msg.setSubject("Reimbursement email");
        msg.setContent(message, "text/html");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
}
