package com.project.assemblyManagementSystem.mapper;

import com.project.assemblyManagementSystem.bo.AssemblyLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssemblyLogMapper {


    public void insertAssemblyLog(AssemblyLog assemblyLog);

    public void deleteAssemblyLog(AssemblyLog assemblyLog);

    public void updateAssemblyLog(AssemblyLog assemblyLog);

    public List<AssemblyLog> selectAssemblyLog(AssemblyLog assemblyLog);



}
