package com.project.assemblyManagementSystem.service;

import com.project.assemblyManagementSystem.bo.TestLog;

import java.util.Date;

public interface QualityTestService {

    public TestLog TestReportGenerator(Integer componentsID, String testItem, String testResults, Date testTimes);

    public int QualityTestDetect(String testResults);

    public String GetTestReport(TestLog testLog);


}
