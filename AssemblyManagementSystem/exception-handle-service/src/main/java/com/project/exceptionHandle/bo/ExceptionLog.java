package com.project.exceptionHandle.bo;

import java.io.Serializable;
import java.util.Date;

public class ExceptionLog implements Serializable {

    private Integer exceptionLogID;

    private Integer assemblyStepID;

    private Integer workstationID;

    private Integer componentsID;

    private String componentsType;

    private Date assemblyDate;

    private String exceptionType;


    public Integer getExceptionLogID() {
        return exceptionLogID;
    }

    public void setExceptionLogID(Integer exceptionLogID) {
        this.exceptionLogID = exceptionLogID;
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

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

}
