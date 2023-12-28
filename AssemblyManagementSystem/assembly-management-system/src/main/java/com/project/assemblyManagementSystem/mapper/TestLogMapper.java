package com.project.assemblyManagementSystem.mapper;

import com.project.assemblyManagementSystem.bo.TestLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestLogMapper {

    public void insertTestLog(TestLog testLog);

    public void deleteTestLog(TestLog testLog);

    public void updateTestLog(TestLog testLog);

    public List<TestLog> selectTestLog(TestLog testLog);

}
