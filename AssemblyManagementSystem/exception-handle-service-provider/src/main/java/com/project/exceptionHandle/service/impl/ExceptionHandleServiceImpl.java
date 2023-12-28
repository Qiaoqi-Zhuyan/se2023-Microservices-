package com.project.exceptionHandle.service.impl;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.alibaba.dubbo.config.annotation.Service;
import com.project.exceptionHandle.assets.UniqueIdGenerator;
import com.project.exceptionHandle.bo.ExceptionLog;
import com.project.exceptionHandle.mapper.ExceptionLogMapper;
import com.project.exceptionHandle.service.ExceptionHandleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service(interfaceClass = ExceptionHandleService.class)
@Component
public class ExceptionHandleServiceImpl implements ExceptionHandleService {

    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    private static final Logger logger = LogManager.getLogger(ExceptionHandleServiceImpl.class);


    private ExceptionLog QueryHandle(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType){

        ExceptionLog exceptionLogQuery = new ExceptionLog();
        exceptionLogQuery.setAssemblyStepID(assemblyStepID);
        exceptionLogQuery.setWorkstationID(workstationID);
        exceptionLogQuery.setComponentsID(componentsID);
        exceptionLogQuery.setComponentsType(componentsType);
        exceptionLogQuery.setAssemblyDate(assemblyDate);
        exceptionLogQuery.setExceptionType(exceptionType);

//        if (assemblyStepID != null){
//            exceptionLogQuery.setAssemblyStepID(assemblyStepID);
//        } else if (workstationID != null) {
//            exceptionLogQuery.setWorkstationID(workstationID);
//        }else if (componentsID != null){
//            exceptionLogQuery.setComponentsID(componentsID);
//        }else if (componentsType != null){
//            exceptionLogQuery.setComponentsType(componentsType);
//        }else if (assemblyDate != null){
//            exceptionLogQuery.setAssemblyDate(assemblyDate);
//        }else if (exceptionType != null){
//            exceptionLogQuery.setExceptionType(exceptionType);
//        }

        return exceptionLogQuery;

    }


    @Override
    public ExceptionLog ExceptionReportGenerator(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType) {
        ExceptionLog exceptionLog = new ExceptionLog();

        int exceptionLogID = UniqueIdGenerator.generateUniqueID();

        exceptionLog.setExceptionLogID(exceptionLogID);
        exceptionLog.setAssemblyStepID(assemblyStepID);
        exceptionLog.setWorkstationID(workstationID);
        exceptionLog.setComponentsID(componentsID);
        exceptionLog.setComponentsType(componentsType);
        exceptionLog.setAssemblyDate(new Date());
        exceptionLog.setExceptionType(exceptionType);

        try {
            exceptionLogMapper.insertExceptionLog(exceptionLog);
        } catch (DataAccessException e){
            logger.error("SQL error ", e);
        } catch (Exception e){
            logger.error("error", e);
        }

        return exceptionLog;
    }

    @Override
    public List<ExceptionLog> ExceptionReportsQuery(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String exceptionType) {
        ExceptionLog exceptionLog = QueryHandle(assemblyStepID, workstationID, componentsID, componentsType, assemblyDate, exceptionType);
        List<ExceptionLog> exceptionLogList = null;
        try{
            exceptionLogList =  exceptionLogMapper.selectExceptionLog(exceptionLog);
        }catch (DataAccessException e){
            logger.error("SQL error ", e);
        }catch (Exception e){
            logger.error("error", e);
        }
        return exceptionLogList;

    }

    @Override
    public List<String> getExceptionReport(List<ExceptionLog> exceptionLogList) {
        List<String> reports = new ArrayList<>();

        for (ExceptionLog log : exceptionLogList) {
            String report = "exceptionLogID: " + log.getExceptionLogID() + "\n" +
                    "assemblyStepID: " + log.getAssemblyStepID() + "\n" +
                    "workstationID: " + log.getWorkstationID() + "\n" +
                    "componentsID: " + log.getComponentsID() + "\n" +
                    "componentsType: " + log.getComponentsType() + "\n" +
                    "assemblyDate: " + (log.getAssemblyDate() != null ? log.getAssemblyDate().toString() : "null") + "\n" +
                    "exceptionType: " + log.getExceptionType() + "\n";
            reports.add(report);
        }

        return reports;
    }

    @Override
    public String getSingleExceptionReport(ExceptionLog exceptionLog) {
        String report = "exceptionLogID: " + exceptionLog.getExceptionLogID() + "\n" +
                "assemblyStepID: " + exceptionLog.getAssemblyStepID() + "\n" +
                "workstationID: " + exceptionLog.getWorkstationID() + "\n" +
                "componentsID: " + exceptionLog.getComponentsID() + "\n" +
                "componentsType: " + exceptionLog.getComponentsType() + "\n" +
                "assemblyDate: " + (exceptionLog.getAssemblyDate() != null ? exceptionLog.getAssemblyDate().toString() : "null") + "\n" +
                "exceptionType: " + exceptionLog.getExceptionType() + "\n";

        return report;
    }
}
