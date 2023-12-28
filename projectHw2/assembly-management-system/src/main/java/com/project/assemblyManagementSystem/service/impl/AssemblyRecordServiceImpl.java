package com.project.assemblyManagementSystem.service.impl;

import com.project.assemblyManagementSystem.assets.UniqueIdGenerator;
import com.project.assemblyManagementSystem.bo.AssemblyLog;
import com.project.assemblyManagementSystem.mapper.AssemblyLogMapper;
import com.project.assemblyManagementSystem.assets.AssemblySatus;
import com.project.assemblyManagementSystem.service.AssemblyRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

@Service
public class AssemblyRecordServiceImpl implements AssemblyRecordService {

    @Autowired
    private AssemblyLogMapper assemblyLogMapper;

    private static final Logger logger = LogManager.getLogger(AssemblyRecordServiceImpl.class);

    @Override
    public AssemblyLog AssemblyDataDetect(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String assemblyStatus) {

        if (Objects.equals(assemblyStatus, AssemblySatus.DEFECT) || Objects.equals(assemblyStatus, AssemblySatus.EXCEPTION))
            return null;
        else {
            AssemblyLog assemblyLog = new AssemblyLog();

            int assemblyLogID = UniqueIdGenerator.generateUniqueID();
            assemblyLog.setAssemblyLogID(assemblyLogID);;
            assemblyLog.setAssemblyStepID(assemblyStepID);
            assemblyLog.setWorkstationID(workstationID);
            assemblyLog.setComponentsID(componentsID);
            assemblyLog.setComponentsType(componentsType);
            assemblyLog.setAssemblyDate(assemblyDate);
            assemblyLog.setAssemblyStatus(assemblyStatus);

            return assemblyLog;
        }

    }

    @Override
    public void recordAssemblyData(AssemblyLog assemblyLog) {
        try {
            assemblyLogMapper.insertAssemblyLog(assemblyLog);
        }catch (DataAccessException e){
            logger.error("SQL error ", e);
        }catch (Exception e){
            logger.error("error: ", e);
        }
    }
}
