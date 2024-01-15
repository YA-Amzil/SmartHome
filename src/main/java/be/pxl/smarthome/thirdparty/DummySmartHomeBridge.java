package be.pxl.smarthome.thirdparty;

import be.pxl.smarthome.domain.DeviceState;
import be.pxl.smarthome.exception.DeviceUnavailableException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Dummy device bridge
 */
@Component
public class DummySmartHomeBridge implements SmartHomeBridge {
    private static final Logger LOGGER = LogManager.getLogger("DeviceBridge");

    public void setState(UUID address, DeviceState state, String settings) throws DeviceUnavailableException {
		String data = (settings == null)? "" :  ", " + settings;
        LOGGER.info("SEND [" + state +  data + "] to [" + address + "]");
	    double random = Math.random();
	    if (random < 0.1) {
			throw new DeviceUnavailableException();
	    }
    }
}
