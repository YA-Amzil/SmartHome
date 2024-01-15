package be.pxl.smarthome.service;

import be.pxl.smarthome.builders.ActionBuilder;
import be.pxl.smarthome.builders.DeviceBuilder;
import be.pxl.smarthome.domain.Action;
import be.pxl.smarthome.domain.Device;
import be.pxl.smarthome.domain.DeviceState;
import be.pxl.smarthome.domain.DeviceType;
import be.pxl.smarthome.repository.DeviceRepository;
import be.pxl.smarthome.thirdparty.DummySmartHomeBridge;

import java.util.UUID;

public class ScenarioServiceTest {

    private DummySmartHomeBridge smartHomeBridge;
    private DeviceRepository deviceRepository;
    private ScenarioService scenarioService;

	private static final UUID THERMOSTAT_UUID = UUID.randomUUID();
    private final Action actionWithSensor = ActionBuilder.anAction()
            .withDevice(DeviceBuilder.aDevice().withDeviceType(DeviceType.DOOR_WINDOW_CONTACT).build())
            .build();
    private final Device thermostat = DeviceBuilder.aDevice()
            .withAddress(THERMOSTAT_UUID)
            .withDeviceType(DeviceType.THERMOSTAT)
            .withDeviceState(DeviceState.OFF)
            .build();
    private final Action actionWithThermostat = ActionBuilder.anAction()
                .withDevice(thermostat)
                .withSettings("{'temp':18.5}")
                .withDeviceState(DeviceState.ON)
                .build();

}
