package com.project.assemblyManagementSystem.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.project.assemblyManagementSystem.service.UserService;
import com.project.exceptionHandle.bo.ExceptionLog;
import com.project.exceptionHandle.service.ExceptionHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class DefectReportApi {

    @Autowired
    private UserService userService;

    @Reference
    private ExceptionHandleService exceptionHandleService;

    @RequestMapping("/DefectReport/DefectReportDetailsQuery")
    public List<ExceptionLog> DefectReportDetailsQuery(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType){
        return exceptionHandleService.ExceptionReportsQuery(assemblyStepID, workstationID, componentsID, componentsType, assemblyDate, exceptionType);
   
    }

    @RequestMapping("/DefectReport/DefectReportDetails")
    public List<String> DefectReportDetails(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType){
         List<ExceptionLog> exceptionLogList =  exceptionHandleService.ExceptionReportsQuery(assemblyStepID, workstationID, componentsID, componentsType, assemblyDate, exceptionType);
         return exceptionHandleService.getExceptionReport(exceptionLogList);

    }

    @RequestMapping("/DefectReport/DefectReportDetailsQueryTest")
    public List<ExceptionLog> DefectReportDetailsQueryTest(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType){

        return exceptionHandleService.ExceptionReportsQuery(1001, workstationID, componentsID, componentsType, assemblyDate, exceptionType);

    }

}
