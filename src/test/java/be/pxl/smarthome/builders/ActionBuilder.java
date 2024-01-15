package be.pxl.smarthome.builders;

import be.pxl.smarthome.domain.*;

public final class ActionBuilder {
    private Scenario scenario;
    private Device device;
    private DeviceState deviceState;
    private String settings;

    private ActionBuilder() {
    }

    public static ActionBuilder anAction() {
        return new ActionBuilder();
    }

    public ActionBuilder withScenario(Scenario scenario) {
        this.scenario = scenario;
        return this;
    }

    public ActionBuilder withDevice(Device device) {
        this.device = device;
        return this;
    }

    public ActionBuilder withSettings(String settings) {
        this.settings = settings;
        return this;
    }

    public ActionBuilder withDeviceState(DeviceState deviceState) {
        this.deviceState = deviceState;
        return this;
    }


    public Action build() {
        Action action = new Action();
        action.setScenario(scenario);
        action.setDevice(device);
        action.setDeviceState(deviceState);
        action.setSettings(settings);
        return action;
    }
}
