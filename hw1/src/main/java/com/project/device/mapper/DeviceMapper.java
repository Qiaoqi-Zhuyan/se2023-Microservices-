package com.project.device.mapper;

import com.project.device.bo.Device;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface DeviceMapper {

    public void insertDevice(Device device);

    public void deleteDevice(Integer deviceID);

    public void updateDevice(Device device);

    public Device selectDeviceByID(Integer deviceID);

    public List<Device> selectDevice(Device device);

    public List<Device> selectAllDevice();

}
