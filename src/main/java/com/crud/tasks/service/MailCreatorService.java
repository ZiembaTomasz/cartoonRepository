package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message){
        List<String> funcionality = new ArrayList<>();
        funcionality.add("You can manage your tasks");
        funcionality.add("Provides connection with Trello account");
        funcionality.add("Application allows sending tasks to Trello");
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye", adminConfig.getGoodbye());
        context.setVariable("company", adminConfig.getCompanyDetail());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_funcionality", funcionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }
    public String buildDailyInfo(String msg){
        List<String>funcionality = new ArrayList<>();
        funcionality.add("You can manage your tasks");
        funcionality.add("Provides connection with Trello account");
        funcionality.add("Your current database");
        Context context = new Context();
        context.setVariable("msg", msg);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye", adminConfig.getGoodbye());
        context.setVariable("company", adminConfig.getCompanyDetail());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_funcionality", funcionality);
        return templateEngine.process("dailyMail/daily-info", context);
    }
}
