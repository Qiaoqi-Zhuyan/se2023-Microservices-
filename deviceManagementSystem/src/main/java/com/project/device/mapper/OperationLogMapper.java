package com.project.device.mapper;

import com.project.device.bo.OperationLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperationLogMapper {

    public void insertOperationLogMapper(OperationLog operationLog);

    public void deleteOperationLogMapper(Integer logID);

    public OperationLog selectOperationLogByID(Integer logID);

    public List<OperationLog> selectOperationLog(OperationLog operationLog);


}
