package com.project.emailAlarm.service;

import java.util.List;


public interface EmailAlarmService {

    public void SendAlarmEmail(List<String> recipients, String subject, String context);

}
