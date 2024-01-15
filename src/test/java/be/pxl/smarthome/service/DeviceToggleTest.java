package be.pxl.smarthome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import be.pxl.smarthome.domain.Device;
import be.pxl.smarthome.domain.DeviceState;
import be.pxl.smarthome.domain.DeviceType;
import be.pxl.smarthome.domain.Room;

public class DeviceToggleTest {
    private List<Device> devices = new ArrayList<>();

    @BeforeEach
    void setUp() {
        devices.add(new Device(new Room("LivingRoom"), "Living room light", UUID.randomUUID(), DeviceType.LIGHT,
                DeviceState.ON));
        devices.add(new Device(new Room("LivingRoom"), "Standing lamp", UUID.randomUUID(), DeviceType.LIGHT,
                DeviceState.OFF));
        devices.add(new Device(new Room("LivingRoom"), "Thermostat", UUID.randomUUID(), DeviceType.THERMOSTAT,
                DeviceState.ON, "{\"temp\": 20.5}"));
    }

    @Test
    void testToggleLight1() {
        Device device = devices.get(0);
        device.toggle();
        assertEquals(DeviceState.OFF, device.getDeviceState());
    }

    @Test
    void testToggleLight2() {
        Device device = devices.get(1);
        device.toggle();
        assertEquals(DeviceState.ON, device.getDeviceState());
    }

    @Test
    void testToggleThermostat() {
        Device device = devices.get(1);
        device.toggle();
        assertEquals(DeviceState.ON, device.getDeviceState());
    }
}
