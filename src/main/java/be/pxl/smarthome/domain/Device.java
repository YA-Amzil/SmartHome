package be.pxl.smarthome.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "Devices")
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;
	private String name;
	private UUID address;
	@Enumerated(value = EnumType.STRING)
	private DeviceType deviceType;
	@Enumerated(value = EnumType.STRING)
	private DeviceState deviceState;
	@JsonProperty("temp")
	private String settings;

	public Device() {
		// JPA only
	}

	// constructor with settings parameter
	public Device(Room room, String name, UUID address, DeviceType deviceType,
			DeviceState deviceState,
			String settings) {
		this.room = room;
		this.name = name;
		this.address = address;
		this.deviceType = deviceType;
		this.deviceState = deviceState;
		this.settings = settings;
	}

	// constructor without settings parameter
	public Device(Room room, String name, UUID address, DeviceType deviceType, DeviceState deviceState) {
		this.room = room;
		this.name = name;
		this.address = address;
		this.deviceType = deviceType;
		this.deviceState = deviceState;
	}

	public Integer getId() {
		return id;
	}

	public Room getRoom() {
		return room;
	}

	public String getName() {
		return name;
	}

	public UUID getAddress() {
		return address;
	}

	public DeviceState getDeviceState() {
		return deviceState;
	}

	public void setDeviceState(DeviceState deviceState) {
		this.deviceState = deviceState;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public String getSettings() {
		return settings;
	}

	public void setSettings(String settings) {
		this.settings = settings;
	}

	public void setAddress(UUID address) {
		this.address = address;
	}

	public boolean isSensor() {
		return deviceType.isSensor();
	}

	public void toggle() {
		deviceState = deviceState.toggle();
	}
}
