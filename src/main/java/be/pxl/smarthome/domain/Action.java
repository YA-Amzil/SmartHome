package be.pxl.smarthome.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Actions")
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "scenario_id")
	private Scenario scenario;
	@ManyToOne
	@JoinColumn(name = "device_id")
	private Device device;
	@Enumerated(EnumType.STRING)
	private DeviceState deviceState;
	private String settings;

	public Action() {
		// JPA only
	}

	public Action(Scenario scenario, Device device, DeviceState deviceState) {
		this.scenario = scenario;
		this.device = device;
		this.deviceState = deviceState;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public void setDeviceState(DeviceState deviceState) {
		this.deviceState = deviceState;
	}

	public DeviceState getDeviceState() {
		return deviceState;
	}

	public Device getDevice() {
		return device;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

	public String getSettings() {
		return settings;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
}
