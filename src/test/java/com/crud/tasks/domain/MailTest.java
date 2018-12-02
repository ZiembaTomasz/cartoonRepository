package com.crud.tasks.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MailTest {
    @Test
    public void getterTest(){
        Mail mail = new Mail("Tom", "Stuff", "Fast", "Copy");
        String email = mail.getMailTo();
        String subject = mail.getSubject();
        String message = mail.getMessage();
        String toCc = mail.getToCc();

        assertEquals("Tom", email);
        assertEquals("Stuff", subject);
        assertEquals("Fast", message);
        assertEquals("Copy", toCc);
    }

}