package com.project.assemblyManagementSystem.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.project.assemblyManagementSystem.assets.AssemblySatus;
import com.project.assemblyManagementSystem.assets.Position;
import com.project.assemblyManagementSystem.bo.TestLog;
import com.project.assemblyManagementSystem.service.QualityTestService;
import com.project.assemblyManagementSystem.service.UserService;
import com.project.emailAlarm.service.EmailAlarmService;
import com.project.exceptionHandle.bo.ExceptionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ComponentQualityTestApi {

    @Autowired
    private QualityTestService qualityTestService;

    @Autowired
    private UserService userService;

    @Reference
    private EmailAlarmService emailAlarmService;

    @RequestMapping("/ComponentQualityTest/QualityTest")
    public void QualityTest(Integer componentsID, String testItem, String testResults, Date testTimes){

        int ReusltMsg = qualityTestService.QualityTestDetect(testResults);
        TestLog testLog = qualityTestService.TestReportGenerator(componentsID, testItem, testResults, testTimes);

        if (ReusltMsg == 0){
            String testReport = qualityTestService.GetTestReport(testLog);
            List<String> recipients  = userService.getEmailAddress(Position.QUALITY_CONTROL);
            String subject = testResults +  " Detected";
            emailAlarmService.SendAlarmEmail(recipients,subject ,testReport);
        }

    }

    @RequestMapping("/ComponentQualityTest/QualityTestTest")
    public void QualityTestTest(Integer componentsID, String testItem, String testResults, Date testTimes){

        Integer componentsID_test = 101;
        String testItem_test = "check1";
        String testResults_test = "unqualified";
        Date testTimes_test = new Date();

        int ReusltMsg = qualityTestService.QualityTestDetect(testResults_test);
        TestLog testLog = qualityTestService.TestReportGenerator(componentsID_test, testItem_test, testResults_test, testTimes_test);

        if (ReusltMsg == 0){
            String testReport = qualityTestService.GetTestReport(testLog);
            List<String> recipients  = userService.getEmailAddress(Position.QUALITY_CONTROL);
            String subject = testResults +  " Detected";
            emailAlarmService.SendAlarmEmail(recipients,subject ,testReport);
        }

    }

}
