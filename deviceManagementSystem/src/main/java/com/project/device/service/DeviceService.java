package com.project.device.service;

import com.project.device.bo.Device;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeviceService {

    public Integer addNewDevice(Integer operatorID, Device device) ;

    public Integer deleteDevice(Integer operatorID, Integer deviceID);

    public Integer updateDeviceStatus(Integer operatorID, Integer device ,String status);

    public Integer updateDeviceInfo(Integer operatorID,Device device);

    public Device findDeviceInfoById(Integer operatorID, Integer deviceID);

    public List<Device> findDeviceInfo(Integer operatorID, Device device);

    public List<Device> findAllDeviceInfo(Integer operatorID);

}
