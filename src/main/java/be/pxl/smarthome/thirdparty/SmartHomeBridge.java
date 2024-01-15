package be.pxl.smarthome.thirdparty;

import be.pxl.smarthome.domain.DeviceState;
import be.pxl.smarthome.exception.DeviceUnavailableException;

import java.util.UUID;

/**
 * A smart home bridge interface
 */
public interface SmartHomeBridge {

	/**
	 * Sends the desired device state and settings to the device with the given address.
	 * @param address address of a device (not sensor)
	 * @param deviceState desired device state to send
	 * @param settings the new device settings to send
	 * @throws DeviceUnavailableException when the device is not available.
	 */
	void setState(UUID address, DeviceState deviceState, String settings) throws DeviceUnavailableException;

}
