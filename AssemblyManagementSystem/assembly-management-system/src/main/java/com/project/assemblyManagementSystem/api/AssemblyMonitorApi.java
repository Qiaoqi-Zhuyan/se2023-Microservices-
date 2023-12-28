package com.project.assemblyManagementSystem.api;


import com.alibaba.dubbo.config.annotation.Reference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.project.assemblyManagementSystem.assets.AssemblySatus;
import com.project.assemblyManagementSystem.assets.Position;
import com.project.assemblyManagementSystem.bo.AssemblyLog;
import com.project.assemblyManagementSystem.mapper.UsrMapper;
import com.project.assemblyManagementSystem.service.AssemblyRecordService;
import com.project.assemblyManagementSystem.service.UserService;
import com.project.emailAlarm.service.EmailAlarmService;
import com.project.exceptionHandle.bo.ExceptionLog;
import com.project.exceptionHandle.service.ExceptionHandleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class AssemblyMonitorApi {

    @Reference
    private EmailAlarmService emailAlarmService;

    @Reference
    private ExceptionHandleService exceptionHandleService;

    @Autowired
    private AssemblyRecordService assemblyRecordService;

    @Autowired
    private UserService userService;

    @RequestMapping("/AssemblyMonitor/AssemblyDataRecorder")
    public void AssemblyDataRecorder(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String assemblyStatus){

        AssemblyLog assemblyLog =  assemblyRecordService.AssemblyDataDetect(assemblyStepID, workstationID,componentsID, componentsType,assemblyDate, assemblyStatus);

        if (assemblyLog == null){
            ExceptionLog exceptionLog =  exceptionHandleService.ExceptionReportGenerator(assemblyStepID, workstationID, componentsID, componentsType, assemblyDate, assemblyStatus);
            String exceptionReport = exceptionHandleService.getSingleExceptionReport(exceptionLog);
            List<String> recipients  = userService.getEmailAddress(Position.ASSEMBLY_MANAGER);
            String subject = AssemblySatus.DEFECT + " / " + AssemblySatus.EXCEPTION + " Detected";
            emailAlarmService.SendAlarmEmail(recipients,subject , exceptionReport);
        }
        else {
            assemblyRecordService.recordAssemblyData(assemblyLog);
        }


    }

    @RequestMapping("/AssemblyMonitor/AssemblyDataRecorderTest")
    public void AssemblyDataRecorderTest(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String assemblyStatus){


        Integer assemblyStepID_test = 1001;
        Integer workstationID_test = 2001;
        Integer componentsID_test = 101;
        String componentsType_test = "type_1";
        Date assemblyDate_test = new Date();
        String assemblyStatus_test = AssemblySatus.COMPLETED;

        AssemblyLog assemblyLog =  assemblyRecordService.AssemblyDataDetect(assemblyStepID_test, workstationID_test,componentsID_test, componentsType_test,assemblyDate_test, assemblyStatus_test);


        if (assemblyLog == null){
            ExceptionLog exceptionLog =  exceptionHandleService.ExceptionReportGenerator(assemblyStepID_test, workstationID_test,componentsID_test, componentsType_test,assemblyDate_test, assemblyStatus_test);
            String exceptionReport = exceptionHandleService.getSingleExceptionReport(exceptionLog);
            List<String> recipients  = userService.getEmailAddress(Position.ASSEMBLY_MANAGER);
            String subject = AssemblySatus.DEFECT + " / " + AssemblySatus.EXCEPTION + " Detected";
            emailAlarmService.SendAlarmEmail(recipients, subject, exceptionReport);
        }
        else {
            assemblyRecordService.recordAssemblyData(assemblyLog);
        }


    }


}
