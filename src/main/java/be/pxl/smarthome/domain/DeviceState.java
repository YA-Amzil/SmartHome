package be.pxl.smarthome.domain;

public enum DeviceState {
	OPEN,
	CLOSED,
	ON,
	OFF,
	UNAVAILABLE;


	public DeviceState toggle() {
		return switch (this) {
			case ON -> OFF;
			case OFF -> ON;
			case OPEN -> CLOSED;
			case CLOSED -> OPEN;
			case UNAVAILABLE -> UNAVAILABLE;
		};
	}
}
