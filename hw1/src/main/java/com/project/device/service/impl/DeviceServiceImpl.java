package com.project.device.service.impl;

import com.project.device.bo.Device;
import com.project.device.bo.OperationLog;
import com.project.device.bo.Operator;
import com.project.device.mapper.DeviceMapper;
import com.project.device.mapper.OperationLogMapper;
import com.project.device.mapper.OperatorMapper;
import com.project.device.model.UniqueIdGenerator;
import com.project.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Autowired
    private OperatorMapper operatorMapper;

    private void GenerateOperationLog(Integer deviceID, String operationType, String operationDetail, Integer operatorID){
        Operator operatorInfo = operatorMapper.selectOperator(operatorID);

        OperationLog operationLog = new OperationLog();
        int logID = UniqueIdGenerator.generateUniqueID();
        operationLog.setLogId(logID);
        operationLog.setOperator(operatorInfo.getName());
        operationLog.setOperationDate(new Date());
        operationLog.setOperationType(operationType);
        operationLog.setOperationDetail(operationDetail);
        operationLog.setDeviceId(deviceID);

        operationLogMapper.insertOperationLogMapper(operationLog);
    }


    @Transactional
    @Override
    public Integer addNewDevice(Integer operatorID, Device device) {

        int deviceID = UniqueIdGenerator.generateUniqueID();
        device.setDeviceId(deviceID);
        deviceMapper.insertDevice(device);

        String operationDetail = "add new Device: " + Integer.toString(deviceID);
        //OperationLog operationLog = GenerateOperationLog(deviceID, "INSERT", operationDetail, operatorID);
        //operationLogMapper.insertOperationLogMapper(operationLog);

        GenerateOperationLog(deviceID, "INSERT", operationDetail, operatorID);


        return 1;
    }

    @Transactional
    @Override
    public Integer deleteDevice(Integer operatorID, Integer deviceID) {
        Device device = deviceMapper.selectDeviceByID(deviceID);
        if(device == null) {
            return 0;
        }else{
            deviceMapper.deleteDevice(deviceID);

            String operationDetail = "delete Device " + Integer.toString(deviceID);
            GenerateOperationLog(deviceID, "DELETE", operationDetail, operatorID);
            //OperationLog operationLog = GenerateOperationLog(deviceID, "DELETE", operationDetail, operatorID);
            return 1;
        }
    }
    @Transactional
    @Override
    public Integer updateDeviceStatus(Integer operatorID, Integer deviceID, String status) {

        assert  Objects.equals(status, "online") ||
                Objects.equals(status, "offline") ||
                Objects.equals(status, "under Maintenance") ||
                Objects.equals(status, "error") ||
                Objects.equals(status, "ready to deployment");

        Device device = deviceMapper.selectDeviceByID(deviceID);
        if (device == null){
            return 0;
        }else
        {
            device.setStatus(status);
            deviceMapper.updateDevice(device);

            String operationDetail = "update Device " + Integer.toString(deviceID) +  " status to " + status ;
            GenerateOperationLog(deviceID, "INSERT", operationDetail, operatorID);
            //OperationLog operationLog = GenerateOperationLog(deviceID, "UPDATE", operationDetail, operatorID);
            //operationLogMapper.insertOperationLogMapper(operationLog);
            return 1;
        }
    }

    @Transactional
    @Override
    public Integer updateDeviceInfo(Integer operatorID, Device device) {

        deviceMapper.updateDevice(device);
        String operationDetail = "updata device info";
        GenerateOperationLog(device.getDeviceId(), "UPDATA", operationDetail, operatorID);
        return 1;
    }

    @Transactional
    @Override
    public Device findDeviceInfoById(Integer operatorID, Integer deviceID) {
        Device device = deviceMapper.selectDeviceByID(deviceID);
//        String operationDetail = "find device " + Integer.toString(deviceID) + " information";
//        GenerateOperationLog(deviceID, "SELECT", operationDetail, operatorID);
        return device;
    }
    @Transactional
    @Override
    public List<Device> findDeviceInfo(Integer operatorID, Device device) {
        return deviceMapper.selectDevice(device);
    }

    @Transactional
    @Override
    public List<Device> findAllDeviceInfo(Integer operatorID) {
        return deviceMapper.selectAllDevice();
    }
}
