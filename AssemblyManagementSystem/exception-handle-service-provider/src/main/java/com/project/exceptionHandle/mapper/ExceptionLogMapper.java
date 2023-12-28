package com.project.exceptionHandle.mapper;

import com.project.exceptionHandle.bo.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExceptionLogMapper {

    public void insertExceptionLog(ExceptionLog exceptionLog);

    public void deleteExceptionLog(ExceptionLog exceptionLog);

    public void updateExceptionLog(ExceptionLog exceptionLog);

    public List<ExceptionLog> selectExceptionLog(ExceptionLog exceptionLog);

}
