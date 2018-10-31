package com.crud.tasks.scheduler;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmailSchedulerTest {
    @Test
    public void test(){
        EmailScheduler emailScheduler = new EmailScheduler();
        emailScheduler.sendInformationMail();

    }

}