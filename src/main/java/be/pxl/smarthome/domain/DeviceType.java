package be.pxl.smarthome.domain;

public enum DeviceType {
	LIGHT(false),
	DOOR_WINDOW_CONTACT(true),
	THERMOSTAT(false);

	private final boolean sensor;

	DeviceType(boolean sensor) {
		this.sensor = sensor;
	}
	public boolean isSensor() {
		return sensor;
	}
}
