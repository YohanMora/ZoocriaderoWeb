/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zoocriadero.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 *
 * @author Yohan Alvarado
 */
public class JavaEmailSender {

    private String emailAddressTo = new String();
    private String msgSubject = new String();
    private String msgText = new String();

    final String USER_NAME = "zoocriaderoweb@gmail.com";   //User name of the Goole(gmail) account
    final String PASSSWORD = "kfbrnyyftkeiqkmd";  //Password of the Goole(gmail) account
    final String FROM_ADDRESS = "zoocriaderoweb@gmail.com";  //From addresss

    public JavaEmailSender() {

    }

    public void createAndSendEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
        sendEmailMessage();
    }

    private void sendEmailMessage() {

        //Create email sending properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER_NAME, PASSSWORD);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USER_NAME)); //Set from address of the email
            message.setContent(msgText, "text/html"); //set content type of the email

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddressTo)); //Set email recipient

            message.setSubject(msgSubject); //Set email message subject
            Transport.send(message); //Send email message

            System.out.println("sent email successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmailAddressTo(String emailAddressTo) {
        this.emailAddressTo = emailAddressTo;
    }

    public void setSubject(String subject) {
        this.msgSubject = subject;
    }

    public void setMessageText(String msgText) {
        this.msgText = msgText;
    }

}
