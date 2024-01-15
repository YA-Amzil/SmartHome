package be.pxl.smarthome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Scenario with the same name already exists")
public class DuplicateScenarioException extends RuntimeException {

	public DuplicateScenarioException(String message) {
		super(message);
	}
}
