package be.pxl.smarthome.api.request;

import be.pxl.smarthome.domain.DeviceState;

public record ActionRequest(int deviceId, DeviceState deviceState, String settings) {
}
