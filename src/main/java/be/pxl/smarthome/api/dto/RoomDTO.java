package be.pxl.smarthome.api.dto;

import java.util.List;

public record RoomDTO(Integer id, String name, List<DeviceDTO> devices) {
    public RoomDTO(String name, List<DeviceDTO> devices) {
        this(null, name, devices);
    }
}
