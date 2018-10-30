package com.crud.tasks.service;


import com.crud.tasks.domain.Mail;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class SimpleEmailService {
    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail){
        LOGGER.info("Starting email preparation..");
        try{
            javaMailSender.send(createMailMessage(mail));
            LOGGER.info("Email has been sent.");

        } catch(MailException e) {
            LOGGER.error("Failed to process email sending...", e.getMessage(), e);
        }
    }
    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        if (mail.getToCc() != null) {
            mailMessage.setCc(mail.getToCc());
        }

        return mailMessage;

    }
}
