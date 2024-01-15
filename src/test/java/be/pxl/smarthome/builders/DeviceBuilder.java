package be.pxl.smarthome.builders;

import be.pxl.smarthome.domain.Device;
import be.pxl.smarthome.domain.DeviceState;
import be.pxl.smarthome.domain.DeviceType;

import java.util.UUID;

public final class DeviceBuilder {
    private String settings;
    private DeviceType deviceType;
    private DeviceState deviceState;
    private UUID address;

    private DeviceBuilder() {
    }

    public static DeviceBuilder aDevice() {
        return new DeviceBuilder();
    }

    public DeviceBuilder withSettings(String settings) {
        this.settings = settings;
        return this;
    }

    public DeviceBuilder withAddress(UUID address) {
        this.address = address;
        return this;
    }

    public DeviceBuilder withDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public DeviceBuilder withDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
        return this;
    }

    public Device build() {
        Device device = new Device();
        device.setSettings(settings);
        device.setDeviceType(deviceType);
        device.setDeviceState(deviceState);
        device.setAddress(address);
		device.setSettings(settings);
        return device;
    }
}
