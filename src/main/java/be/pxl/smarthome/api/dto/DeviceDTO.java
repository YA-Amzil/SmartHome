package be.pxl.smarthome.api.dto;

import be.pxl.smarthome.domain.DeviceState;
import be.pxl.smarthome.domain.DeviceType;

public record DeviceDTO(Integer id, String name, DeviceType type, String room, DeviceState state) {

}
