package be.pxl.smarthome.controller;

import be.pxl.smarthome.api.dto.DeviceDTO;
import be.pxl.smarthome.api.dto.RoomDTO;
import be.pxl.smarthome.domain.DeviceType;
import be.pxl.smarthome.service.DeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "devices")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<DeviceDTO> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping(path = "/type") // moet dezelfde naam hebben als de parameter in de url ook in deze methode
    public List<RoomDTO> getAllDevicesByType(@RequestParam DeviceType type) {
        return deviceService.getAllDevicesByDeviceType(type);
    }

    @PostMapping(path = "/{deviceId}/toggle")
    public void toggleDevice(@PathVariable Integer deviceId) {
        deviceService.toggleDevice(deviceId);
    }
}
