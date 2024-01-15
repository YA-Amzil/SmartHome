package be.pxl.smarthome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class InvalidDeviceStateException extends RuntimeException {
    public InvalidDeviceStateException(String message) {
        super(message);
    }
}
