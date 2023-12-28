package com.project.exceptionHandle.service;


import com.project.exceptionHandle.bo.ExceptionLog;

import java.util.Date;
import java.util.List;


public interface ExceptionHandleService {

    public ExceptionLog ExceptionReportGenerator(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType);

    public List<ExceptionLog > ExceptionReportsQuery(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType);

    public List<String> getExceptionReport(List<ExceptionLog> exceptionLogList);

    public String getSingleExceptionReport(ExceptionLog exceptionLog);

}
