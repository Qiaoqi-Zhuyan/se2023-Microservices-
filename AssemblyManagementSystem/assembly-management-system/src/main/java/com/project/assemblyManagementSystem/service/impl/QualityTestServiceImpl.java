package com.project.assemblyManagementSystem.service.impl;

import com.project.assemblyManagementSystem.assets.UniqueIdGenerator;
import com.project.assemblyManagementSystem.bo.TestLog;
import com.project.assemblyManagementSystem.mapper.TestLogMapper;
import com.project.assemblyManagementSystem.service.QualityTestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QualityTestServiceImpl implements QualityTestService {

    @Autowired
    private TestLogMapper testLogMapper;

    private String alarmSatus;

    private static final Logger logger = LogManager.getLogger(QualityTestServiceImpl.class);


    @Override
    public int QualityTestDetect(String testResults) {
        if (testResults.equals("unqualified")) {
            this.alarmSatus = "alarm";
            return 0;
        }
        else {
            this.alarmSatus = "no_alarm";
            return 1;
        }
    }

    @Override
    public String GetTestReport(TestLog testLog) {

        String report = "testLogID: " + Integer.toString(testLog.getTestLogID()) + "\n" +
                        "componentsID: " + Integer.toString(testLog.getComponentsID()) + "\n" +
                        "testItem: " + testLog.getTestItem() + "\n" +
                        "testResults: " + testLog.getTestResults() + "\n" +
                        "testTimes: " + testLog.getTestTimes() + "\n" +
                        "alarmStatus: " + testLog.getAlarmStatus() + "\n";

        return report;
    }

    @Override
    public TestLog TestReportGenerator(Integer componentsID, String testItem, String testResults, Date testTimes) {

        TestLog testLog = new TestLog();

        int testLogID = UniqueIdGenerator.generateUniqueID();
        testLog.setTestLogID(testLogID);
        testLog.setComponentsID(componentsID);
        testLog.setTestItem(testItem);
        testLog.setTestResults(testResults);
        testLog.setTestTimes(testTimes);
        testLog.setAlarmStatus(this.alarmSatus);
        try {
            testLogMapper.insertTestLog(testLog);
        }catch (DataAccessException e){
            logger.error("Sql error", e);
        }catch (Exception e){
            logger.error("error", e);
        }

        return testLog;
    }

}
