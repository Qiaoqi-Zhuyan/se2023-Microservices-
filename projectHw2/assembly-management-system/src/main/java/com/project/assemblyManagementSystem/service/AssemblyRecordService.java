package com.project.assemblyManagementSystem.service;

import com.project.assemblyManagementSystem.bo.AssemblyLog;

import java.util.Date;

public interface AssemblyRecordService {

    public AssemblyLog AssemblyDataDetect(Integer assemblyStepID, Integer workstationID, Integer componentsID, String componentsType, Date assemblyDate, String assemblyStatus);

    public void recordAssemblyData(AssemblyLog assemblyLog);

}
