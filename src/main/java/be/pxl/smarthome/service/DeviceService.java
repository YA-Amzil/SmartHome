package be.pxl.smarthome.service;

import be.pxl.smarthome.api.dto.DeviceDTO;
import be.pxl.smarthome.api.dto.RoomDTO;
import be.pxl.smarthome.domain.Device;
import be.pxl.smarthome.domain.DeviceType;
import be.pxl.smarthome.exception.NotFoundException;
import be.pxl.smarthome.repository.DeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {

	private final DeviceRepository deviceRepository;

	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<DeviceDTO> getAllDevices() {
		return deviceRepository.findAll().stream()
				.map(d -> new DeviceDTO(d.getId(), d.getName(), d.getDeviceType(), d.getRoom().getName(),
						d.getDeviceState()))
				.toList();
	}

	public List<RoomDTO> getAllDevicesByDeviceType(DeviceType deviceType) {
		// TODO implement the query in DeviceRepository, call the query and return the
		// result.
		List<Device> devices = deviceRepository.findByDeviceType(deviceType);
		var devicesByRoom = devices.stream()
				.collect(Collectors.groupingBy(Device::getRoom,
						Collectors.mapping(d -> new DeviceDTO(d.getId(), d.getName(),
								d.getDeviceType(),
								d.getRoom().getName(), d.getDeviceState()), Collectors.toList())));

		return devicesByRoom.entrySet().stream()
				.map(entry -> new RoomDTO(entry.getKey().getId(), entry.getKey().getName(),
						entry.getValue()))
				.collect(Collectors.toList());

		// var devices = deviceRepository.findByDeviceType(deviceType);
		// List<RoomDTO> dataToReturn = new ArrayList<>();

		// // group devices by room name
		// var devicesByRoom = devices.stream().collect(Collectors.groupingBy(d ->
		// d.getRoom().getName(),
		// Collectors.mapping(d -> new DeviceDTO(d.getId(), d.getName(),
		// d.getDeviceType(), d.getRoom().getName(),
		// d.getDeviceState()), Collectors.toList())));

		// devicesByRoom.forEach((roomName, deviceDTOs) -> dataToReturn.add(new
		// RoomDTO(roomName, deviceDTOs)));

		// return dataToReturn;
	}

	@Transactional
	public void toggleDevice(int deviceId) {
		Device device = deviceRepository.findById(deviceId)
				.orElseThrow(() -> new NotFoundException("No device with id [" + deviceId + "]"));
		device.toggle();
	}
}
