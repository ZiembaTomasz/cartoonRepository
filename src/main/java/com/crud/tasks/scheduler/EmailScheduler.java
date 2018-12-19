package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    @Autowired
    private SimpleEmailService simpleEmailService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT = "Task: Once a day email";



    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationMail(){
        long size = taskRepository.count();
        String msg = "Currently in database you got";
        msg += size;
        if(size > 1){
            msg += "tasks";
        } else {
            msg += "task";
        }
        System.out.println(msg);
        simpleEmailService.sendInfo(new Mail(adminConfig.getAdminMail(), SUBJECT, msg,
                "ziembatomasz88kod@gmail.com" ));
    }
}
