package com.project.device.api;

import com.project.device.bo.Device;
import com.project.device.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class DeviceApi {


    @Autowired
    private DeviceService deviceService;

    @RequestMapping("/device/getDeviceInfoByID")
    public Device getDeviceInfoByID(Integer operatorID, Integer deviceID){
        Device device = new Device();
        try {
            device = deviceService.findDeviceInfoById(1, 1);
            //device = deviceService.findDeviceInfoById(operatorID, deviceID);

        }catch (Exception e){
            System.out.println(e);
        }

        if (device == null){
            System.out.println("No Device find");
            return null;
        }else {
            return device;
        }
    }

//    @RequestMapping("/device/getDeviceInfo")
//    public List<Device> getDeviceInfo(Integer operator, Device device){
//        List<Device> foundDevices = null;
//        try{
//            Device device1 = new Device();
//            device1.setStatus("online");
//            foundDevices = deviceService.findDeviceInfo(1, device1);
//            //foundDevices = deviceService.findDeviceInfo(operator, device);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//        if (foundDevices == null){
//
//            System.out.println("No device found");
//            return null;
//        }else {
//            return foundDevices;
//        }
//    }

    @RequestMapping("/device/getDeviceInfo")
    public List<Device> getDeviceInfo(Integer operator, Integer deviceId, String name, String type, String status, String manufacturer, Date manufactureDate){

        Device device = new Device();
        device.setDeviceId(deviceId);
        device.setName(name);
        device.setType(type);
        device.setStatus("online");
        device.setManufacturer(manufacturer);
        device.setManufactureDate(manufactureDate);


        List<Device> foundDevices = null;
        try{
//            Device device1 = new Device();
//            device1.setStatus("online");
//            foundDevices = deviceService.findDeviceInfo(1, device1);
            foundDevices = deviceService.findDeviceInfo(1, device);
        }catch (Exception e){
            System.out.println(e);
        }

        if (foundDevices == null){

            System.out.println("No device found");
            return null;
        }else {
            return foundDevices;
        }
    }




    //TODO
    @RequestMapping("/device/getAllDeviceInfo")
    public List<Device> getAllDeviceInfo(Integer operatorID){
        List<Device> foundDevices = null;
        try{
            foundDevices = deviceService.findAllDeviceInfo(1);
            //foundDevices = deviceService.findAllDeviceInfo(operatorID);
        }catch (Exception e){
            System.out.println(e);
        }

        if (foundDevices == null){
            System.out.println("No device found");
            return null;
        }else {
            return foundDevices;
        }
    }


    @RequestMapping("/device/addNewDevice")
    public void addNewDevice(Integer operatorID, String name, String status, String manufacturer, Date manufactureDate){

        Device newDevice = new Device();
        newDevice.setName(name);
        newDevice.setStatus(status);
        newDevice.setManufacturer(manufacturer);
        newDevice.setManufactureDate(manufactureDate);

        Device device1 = new Device();
        device1.setName("Name_test");
        device1.setType("Type_test");
        device1.setManufacturer("Manufacturer_test");
        device1.setStatus("status_test");
        device1.setManufactureDate(new Date());

        try {
            int resultMsg =  deviceService.addNewDevice(1, device1);
           //int resultMsg =  deviceService.addNewDevice(operatorID, newDevice);
           if (resultMsg == 1){
               System.out.println("SUCCESS");
           }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @RequestMapping("/device/deletedDevice")
    public void deletedDevice(Integer operatorID, Integer deviceID){

        try{
            int resultMsg = deviceService.deleteDevice(1, 254109752);
            //int resultMsg = deviceService.deleteDevice(operatorID, deviceID);
            if (resultMsg == 1){
                System.out.println("SUCCESS");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

//    @RequestMapping("/device/UpdateDeviceStatus")
//    public void UpdateDeviceStatus(Integer operatorID, Integer deviceID ,String status){
//
//        try{
//            int resultMsg = deviceService.updateDeviceStatus(1, 1, "error");
//            //int resultMsg = deviceService.updateDeviceStatus(operatorID, deviceID,status);
//            if (resultMsg == 1){
//                System.out.println("SUCCESS");
//            }else {
//                System.out.println("No such device");
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//    }

    @RequestMapping("/device/UpdateDeviceInfoByID")
    public void UpdateDeviceInfoByID(Integer operatorID, Integer deviceId, String name, String type, String status, String manufacturer, Date manufactureDate){

        Device device = deviceService.findDeviceInfoById(1, 1);
        //Device device = deviceService.findDeviceInfoById(operatorID, deviceId);
        if(device == null){
            System.out.println("No such device");
        }

        assert device != null;

        if(name != null)
            device.setName(name);
        if (type != null)
            device.setType("type_test");
        if (status != null)
            device.setStatus(status);
        if (manufacturer != null)
            device.setManufacturer(manufacturer);
        if (manufactureDate != null)
            device.setManufactureDate(manufactureDate);

        try{
//            Device device1 = deviceService.findDeviceInfoById(1, 1);
//
//            System.out.println(device1.getType());
//            device1.setType("Type 10");
//            System.out.println(device1.getType());
//
//            int resultMsg = deviceService.updateDeviceInfo(1,device1);

            int resultMsg = deviceService.updateDeviceInfo(1,device);
            if (resultMsg == 1){
                System.out.println("SUCCESS");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }


}
