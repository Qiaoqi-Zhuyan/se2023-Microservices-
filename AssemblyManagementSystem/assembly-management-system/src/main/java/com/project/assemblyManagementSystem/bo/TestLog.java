package com.project.assemblyManagementSystem.bo;

import java.util.Date;

public class TestLog {


    private Integer testLogID;

    private Integer componentsID;

    private String testItem;

    private String testResults;

    private Date testTimes;

    private String alarmStatus;

    public Integer getTestLogID() {
        return testLogID;
    }

    public void setTestLogID(Integer testLogID) {
        this.testLogID = testLogID;
    }

    public Integer getComponentsID() {
        return componentsID;
    }

    public void setComponentsID(Integer componentsID) {
        this.componentsID = componentsID;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public Date getTestTimes() {
        return testTimes;
    }

    public void setTestTimes(Date testTimes) {
        this.testTimes = testTimes;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

}
