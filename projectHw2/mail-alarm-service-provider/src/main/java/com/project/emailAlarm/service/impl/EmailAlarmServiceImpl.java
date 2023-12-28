package com.project.emailAlarm.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.project.emailAlarm.service.EmailAlarmService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = EmailAlarmService.class)
@Component
public class EmailAlarmServiceImpl implements EmailAlarmService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailProperties mailProperties;

    private static final Logger logger = LogManager.getLogger(EmailAlarmServiceImpl.class);


    @Override
    public void SendAlarmEmail(List<String> recipients, String subject, String context) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.getUsername());
        message.setTo(recipients.toArray(new String[0]));
//        message.setTo("1625817690@qq.com");
        message.setSubject(subject);
        message.setText(context);
        try{
            mailSender.send(message);
        }catch (MailAuthenticationException e){
            logger.error("Authentication error", e);
        }catch (MailSendException e){
            logger.error("MailSendException", e);
        }catch (MailException e){
            logger.error("mailException", e);
        }catch (Exception e){
            logger.error("error", e);
        }
    }
}
