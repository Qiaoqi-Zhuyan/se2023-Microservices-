package com.project.assemblyManagementSystem.bo;

import java.util.Date;

public class AssemblyLog {

    private Integer assemblyLogID;
    private Integer assemblyStepID;
    private Integer workstationID;
    private Integer componentsID;
    private String componentsType;
    private Date assemblyDate;
    private String assemblyStatus;

    public Integer getAssemblyLogID() {
        return assemblyLogID;
    }

    public void setAssemblyLogID(Integer assemblyLogID) {
        this.assemblyLogID = assemblyLogID;
    }

    public Integer getAssemblyStepID() {
        return assemblyStepID;
    }

    public void setAssemblyStepID(Integer assemblyStepID) {
        this.assemblyStepID = assemblyStepID;
    }

    public Integer getWorkstationID() {
        return workstationID;
    }

    public void setWorkstationID(Integer workstationID) {
        this.workstationID = workstationID;
    }

    public Integer getComponentsID() {
        return componentsID;
    }

    public void setComponentsID(Integer componentsID) {
        this.componentsID = componentsID;
    }

    public String getComponentsType() {
        return componentsType;
    }

    public void setComponentsType(String componentsType) {
        this.componentsType = componentsType;
    }

    public Date getAssemblyDate() {
        return assemblyDate;
    }

    public void setAssemblyDate(Date assemblyDate) {
        this.assemblyDate = assemblyDate;
    }

    public String getAssemblyStatus() {
        return assemblyStatus;
    }

    public void setAssemblyStatus(String assemblyStatus) {
        this.assemblyStatus = assemblyStatus;
    }

}
